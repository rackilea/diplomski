public static int longestNonRepeating(final String s) {
    final Set<Character> unique = new HashSet<>();
    int max = 0;
    for (int i = 0; i < s.length(); ++i) {
        final char c = s.charAt(i);
        if (!unique.add(c)) {
            for (int j = i - unique.size(); j < i; ++j) {
                if (s.charAt(j) != c) {
                    unique.remove(s.charAt(j));
                } else {
                    break;
                }
            }
        }
        max = Math.max(max, unique.size());
    }
    return max;
}