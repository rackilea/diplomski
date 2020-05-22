/**
 * @return
 */
private String generateKey() {
    try {
        SecureRandom random = new SecureRandom();
        return new String(random.generateSeed(16), "ISO-8859-1");
    } catch (UnsupportedEncodingException u) {

    }
    return "";
}