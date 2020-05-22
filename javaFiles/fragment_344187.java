static void logCharacters(String text) {
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        System.out.println(c + " " + Integer.toHexString(c));
    }
}