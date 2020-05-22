StringBuilder hexString = new StringBuilder();
for (int i = 0; i < digest.length; i++) {
    String hex = Integer.toHexString(0xFF & digest[i]);
    if (hex.length() == 1) {
        hexString.append('0');
    }
    hexString.append(hex);
}
String hash = hexString.toString();