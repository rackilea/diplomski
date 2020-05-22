static List<String> generatePatterns(String input) {
    if (! input.matches("[PS]{0,30}"))
        throw new IllegalArgumentException("Invalid input: " + input);
    final int end = 1 << input.length();
    char[] chars = new char[input.length()];
    List<String> result = new ArrayList<>(end);
    for (int combo = 0; combo < end; combo++) {
        for (int i = input.length() - 1, bits = combo; i >= 0; i--, bits >>>= 1)
            chars[i] = (char) (input.charAt(i) + 1 + (bits & 1));
        result.add(new String(chars));
    }
    return result;
}