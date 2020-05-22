/**
 * *** THIS METHOD BY NO MEANS PROVIDES A SECURE ENCRYPTION ***<BR><BR>
 * <p>
 * This is an extremely easy String encryption algorithm that encodes the
 * supplied string to Base64 then applies a Caesar Cipher (which is a shift
 * cipher). See: https://en.wikipedia.org/wiki/Caesar_cipher<br><br>
 * <p>
 * You MUST use the provided easyDecrypt() method to decrypt a string that
 * has been encrypted with this method.<br><br>
 *
 * @param inputString (String) The string to encrypt.<br>
 *
 * @return (String) The encrypted string.<br>
 */
public static String easyEncrypt(String inputString) {
    try {
        String b64encoded = Base64.getEncoder().encodeToString(inputString.getBytes("UTF-8"));

        // Reverse the string
        String reverse = new StringBuffer(b64encoded).reverse().toString();

        StringBuilder tmp = new StringBuilder();
        final int OFFSET = 4;
        for (int i = 0; i < reverse.length(); i++) {
            tmp.append((char) (reverse.charAt(i) + OFFSET));
        }
        return tmp.toString();
    }
    catch (UnsupportedEncodingException ex) {
        ex.printStackTrace();
    }
    return "";
}