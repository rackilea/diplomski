final long CKA_VALUE_LEN = 0x00000161;

byte[] deriveKey(byte[] publicKey, byte[] salt, long keyDerivationFunction) throws Exception {
    // setting up mechanism:
    EcDH1KeyDerivationParameters params = new EcDH1KeyDerivationParameters(keyDerivationFunction, salt, publicKey);
    Mechanism mechanism = Mechanism.get(PKCS11Constants.CKM_ECDH1_DERIVE );
    mechanism.setParameters(params);

    // setting up keyTemplate, specifying how the derived key looks like:
    Key keyTemplate = new AESSecretKey();
    keyTemplate.putAttribute(CKA_VALUE_LEN, new Long(32));

    AESSecretKey derivedKey = ((AESSecretKey)session.deriveKey(mechanism, key, keyTemplate));
    return derivedKey.getValue().getByteArrayValue();
}