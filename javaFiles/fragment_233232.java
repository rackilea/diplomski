public static String createDecipherCommon(byte[] text, byte[] key, String iv, String tag) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, InvalidAlgorithmParameterException, UnsupportedEncodingException, DecoderException {
        byte[] ivBytes = Base64.getDecoder().decode(iv.getBytes());
        byte[] tagBytes = Base64.getDecoder().decode(tag.getBytes());
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, ivBytes, 0, ivBytes.length));
        cipher.updateAAD("aad".getBytes());
        return new String(cipher.doFinal(text, 0, text.length));
    }