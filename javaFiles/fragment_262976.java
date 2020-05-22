public String computeHmac(String baseString, String key)
    throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException
{
    Mac mac = Mac.getInstance("HmacSHA1");
    SecretKeySpec secret = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
    mac.init(secret);
    byte[] digest = mac.doFinal(baseString.getBytes());
    return Base64.encode(digest);
}