private static String encodeSemiEncoded(String semiEncondedUrl) {
    final String ALLOWED_CHAR = "!*'();:@&=+$,/?#[]-_.~";
    StringBuilder encoded = new StringBuilder();
    for(char ch: semiEncondedUrl.toCharArray()) {
        boolean shouldEncode = ALLOWED_CHAR.indexOf(ch) == -1 && !Character.isLetterOrDigit(ch) || ch > 127;
        if(shouldEncode) {
            encoded.append(String.format("%%%02X", (int)ch));
        } else {
            encoded.append(ch);
        }
    }
    return encoded.toString();
}