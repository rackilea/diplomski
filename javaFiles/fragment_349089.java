public static byte[] binaryToBytes(String input) {
    // TODO: Argument validation (nullity, length)
    byte[] ret = new byte[input.length() / 8];
    for (int i = 0; i < ret.length; i++) {
        String chunk = input.substring(i * 8, i * 8 + 8);
        ret[i] = (byte) Short.parseShort(chunk, 2);
    }
    return ret;
}