static byte[] gcmDecrypt(byte[] ct, byte[] key, byte[] iv, byte[] aad) throws Exception {
        AEADParameters parameters = new AEADParameters(new KeyParameter(key), 128, iv, aad);
        GCMBlockCipher gcmEngine = new GCMBlockCipher(new AESFastEngine());
        gcmEngine.init(false, parameters);
        byte[] pt = new byte[gcmEngine.getOutputSize(ct.length)];
        int len = gcmEngine.processBytes(ct, 0, ct.length, pt, 0);
        gcmEngine.doFinal(pt, len);
        return pt;
    }

    static byte[] gcmEncrypt(byte[] pt, byte[] key, byte[] iv, byte[] aad) throws Exception {
        AEADParameters parameters = new AEADParameters(new KeyParameter(key), 128, iv, aad);
        GCMBlockCipher gcmEngine = new GCMBlockCipher(new AESFastEngine());
        gcmEngine.init(true, parameters);
        byte[] ct = new byte[gcmEngine.getOutputSize(pt.length)];
        int len = gcmEngine.processBytes(pt, 0, pt.length, ct, 0);
        gcmEngine.doFinal(ct, len);
        return ct;
    }