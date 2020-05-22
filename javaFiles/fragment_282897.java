public class RSAFunc {

    private static RSAFunc instance = null;

    private final String CryptMode = "RSA/ECB/PKCS1Padding";
    private final KeyPair kp;
    private final KeyPairGenerator kpg;
    private final Key privKey;
    private final RSAPublicKey pubkey;

    private RSAFunc() {
        // generate specified length of keypair and store the public and private key
    }

    public static synchronized RSAFunc getInstance() {
        if (instance == null) {
            instance = new RSAFunc();
        }
        return instance;
    }

    public String decryptMsg(String msg) {
        // decrypt RSA encrypted message
    }

    public String encryptMsg(String msg) {
        // encrypt message with RSA
    }

    public String getPubKey() {
        // return public key as string
    }
}