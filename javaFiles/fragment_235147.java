public class HelloWorld {

private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public static void main(String[] args) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(55);
        localStringBuilder.append("market-gap");
        localStringBuilder.append("marjet-gre");
        localStringBuilder.append("1");
        localStringBuilder.append("05/19/1989");
        localStringBuilder.append("6.3.0");
        localStringBuilder.append("0");
        localStringBuilder.append("");
        localStringBuilder.append("en");
        localStringBuilder.append("");
        localStringBuilder.append("00e0533117bb8707");
        String paramString1 = localStringBuilder.toString();

        String strrrr = sha256(paramString1);

        System.out.println(strrrr);
    }

    public static String encodeHex(byte[] arrby) {
        StringBuilder stringBuilder = new StringBuilder(arrby.length * 2);
        for (int i = 0; i < arrby.length; ++i) {
            stringBuilder.append(DIGITS[(arrby[i] & 0xF0) >>> 4]);
            stringBuilder.append(DIGITS[arrby[i] & 0x0F]);
        }
        return stringBuilder.toString();
    }

    public static String sha256(String paramString) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
            return encodeHex(localMessageDigest.digest(paramString.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            // ThrowableExtension.printStackTrace(e);
        }
        return null;
    }

}