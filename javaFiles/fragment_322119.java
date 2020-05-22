public static String duplicate(String s) {
    BitSet bits = new BitSet();
    StringBuffer string = new StringBuffer(s.length());

    for (int i = 0; i < s.length(); i++) {
        if (!bits.get(s.charAt(i))) {
            bits.set(s.charAt(i));
            string.append(s.charAt(i));
        }
    }
    return string.toString();
}