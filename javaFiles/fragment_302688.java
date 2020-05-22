public final class FlexiDemo {

    private FlexiDemo() {
    }

    static {
        // register the FlexiECProvider
        addProvider(new FlexiECProvider());
    }

    // similarly to the "registry" above, make an "uber" registry
    private static final Gson flexiGson = new GsonBuilder()
            .registerTypeAdapterFactory(getFlexiTypeAdapterFactory())
            .create();

    public static void main(final String... args)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException, InvalidKeyException, SignatureException {
        // create a state
        final State state = initiate();
        // dump the payload to stdout
        out.println(state.keyPairJson);
        // ensure that the key pair has been restored correctly
        validate(state);
    }

    private static State initiate()
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, SignatureException, InvalidKeyException {
        final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECIES", "FlexiEC");
        final AlgorithmParameterSpec algorithmParameterSpec = new BrainpoolP160r1();
        keyPairGenerator.initialize(algorithmParameterSpec, new SecureRandom());
        final KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // create a signature to sign with
        final Signature toSignWith = Signature.getInstance("SHA1withECDSA", "FlexiEC");
        toSignWith.initSign(keyPair.getPrivate());
        final byte[] message = "The quick brown fox jumps over the lazy dog".getBytes();
        toSignWith.update(message);
        // create a state to be passed to the consumer method
        return new State(message, toSignWith.sign(), flexiGson.toJson(keyPair));
    }

    private static void validate(final State state)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // deserialize the key pair from the state
        final KeyPair keyPair = flexiGson.fromJson(state.keyPairJson, KeyPair.class);
        // create a signature to verify with
        final Signature toVerifyWith = Signature.getInstance("SHA1withECDSA", "FlexiEC");
        toVerifyWith.initVerify(keyPair.getPublic());
        toVerifyWith.update(state.message);
        // verify it's fine
        if ( !toVerifyWith.verify(state.signature) ) {
            throw new IllegalArgumentException("Signature is not valid");
        }
    }

    private static final class State {

        private final byte[] message;
        private final byte[] signature;
        private final String keyPairJson;

        private State(final byte[] message, final byte[] signature, final String keyPairJson) {
            this.message = message;
            this.signature = signature;
            this.keyPairJson = keyPairJson;
        }

    }

}