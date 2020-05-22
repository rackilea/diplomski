public class HexUtils {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String encodeWithHex(@NonNull byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0, j = 0; i < bytes.length; i++, j += 2) {
            int v = bytes[i] & 0xFF;
            hexChars[j] = HEX_ARRAY[v >>> 4];
            hexChars[j + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] fromHexString(@NonNull String hexStr) {
        hexStr = hexStr.replace(" ", ""); // support spaces
        if (hexStr.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid HEX string " + hexStr);
        }

        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < result.length; i++) {
            int high = fromHexChar(hexStr, i * 2) << 4;
            int low = fromHexChar(hexStr, i * 2 + 1);
            result[i] = (byte) ((high | low) & 0xFF);
        }
        return result;
    }

    private static int fromHexChar(String hexStr, int index) {
        char ch = hexStr.charAt(index);
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'f') {
            return 10 + (ch - 'a');
        } else if (ch >= 'A' && ch <= 'F') {
            return 10 + (ch - 'A');
        } else {
            throw new IllegalArgumentException("Invalid HEX string: " + hexStr);
        }
    }

}