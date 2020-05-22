public class GravityManager {

public static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {

    SecretKey secretKey = null;

    byte[] keyBytes = keyString.getBytes();
    secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");

    Mac mac = Mac.getInstance("HmacSHA1");

    mac.init(secretKey);

    byte[] text = baseString.getBytes();

    return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
}