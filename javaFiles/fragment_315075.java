public static String toHexString(byte[] bytes) {
    StringBuilder sb = new StringBuilder(18);
    for (int i = bytes.length - 1; i >= 0; i--) {
        if (sb.length() > 0)
            sb.append(':');
        sb.append(String.format("%02x", bytes[i]));
    }

    return sb.toString();

}