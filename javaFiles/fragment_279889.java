public static boolean hasDiacritics(String s) {
    // Decompose any á into a and combining-'.
    String s2 = Normalizer.normalize(s, Normalizer.Form.NFD);
    return s2.matches("(?s).*\\p{InCombiningDiacriticalMarks}.*");
    //return !s2.equals(s);
}