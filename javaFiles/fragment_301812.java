public static void encode(FileOutputStream out, String text) throws IOException {
    for (int i = 0; i < text.length() - 7; i += 8) {
        String byteToParse = text.substring(i, Math.min(text.length(), i + 8));
        out.write((byte) Integer.parse(byteToParse, 2));
    }
    // caller created the out so should be the one to close it.
}