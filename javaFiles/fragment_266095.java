byte[] getSharedSecret(byte[] publicKey) throws Exception{
    // setting up mechanism:
    EcDH1KeyDerivationParameters params = new EcDH1KeyDerivationParameters(DHKeyDerivationParameters.KeyDerivationFunctionType.NULL, null, publicKey);
    Mechanism mechanism = Mechanism.get(PKCS11Constants.CKM_ECDH1_DERIVE );
    mechanism.setParameters(params);

    // four our PKCS#11 module, using a GenericSecretKey without length returns
    // the complete derived secret:
    Key keyTemplate = new GenericSecretKey();

    GenericSecretKey derivedKey = ((GenericSecretKey)session.deriveKey(mechanism, key, keyTemplate));
    return derivedKey.getValue().getByteArrayValue();
}