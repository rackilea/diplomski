// Warm-up
    for (int i = 0; i < 100000; i++) {
        sr.nextBytes(nonce);
        aes_gcm.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_LENGTH, nonce));
        aes_gcm.doFinal(new byte[16]);
    }