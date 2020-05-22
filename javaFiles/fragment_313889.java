String encodeURL(String s) {
    byte[] bytes = s.getBytes("UTF-8");
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        String hex = String.format("%%%02X", ((int)b) & 0xFF);
        sb.append(hex);
    }
    return sb.toString();
}