public static String getGuidFromByteArray(byte[] bytes) {
    StringBuilder buffer = new StringBuilder();
    for(int i=0; i<bytes.length; i++) {
        buffer.append(String.format("%02x", bytes[i]));
    }
    return buffer.toString();
}