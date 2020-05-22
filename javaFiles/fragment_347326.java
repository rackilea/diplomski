public static String getHac(String dataUno,  String keyUno) 
        throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, DecoderException {

    SecretKey secretKey;
    Mac mac = Mac.getInstance("HMACSHA256");

    byte[] keyBytes = Hex.decodeHex(keyUno);

    secretKey = new SecretKeySpec(keyBytes, mac.getAlgorithm());

    mac.init(secretKey);

    byte[] text = dataUno.getBytes("UTF-8");

    byte[] encodedText = mac.doFinal(text);
    return new String(Base64.encodeBase64(encodedText)).trim();
}