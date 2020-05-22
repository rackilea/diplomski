public String fromHex(String hex) throws UnsupportedEncodingException {
    hex = hex.replaceAll("^(00)+", "");
    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < hex.length(); i += 2) {
        bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
    }
    return new String(bytes);
}