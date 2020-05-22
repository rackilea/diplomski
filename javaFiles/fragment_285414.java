/**
 * This method is used to decrypt string that have been encrypted with the
 * provided easyEncrypt() method.<br><br>
 * <p>
 * Simply supply the encrypted string.<br><br>
 *
 * @param inputString (String) The encrypted string which was created by the
 *                    easyEncrypt() Method.<br>
 *
 * @return (String) The original string decrypted.<br>
 */
public static String easyDecrypt(String inputString) {
    StringBuilder tmp = new StringBuilder();
    final int OFFSET = 4;
    for (int i = 0; i < inputString.length(); i++) {
        tmp.append((char) (inputString.charAt(i) - OFFSET));
    }

    String reversed = new StringBuffer(tmp.toString()).reverse().toString();
    return new String(Base64.getDecoder().decode(reversed));
}