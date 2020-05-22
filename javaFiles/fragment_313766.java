public static String dedup(String text) {
    Set<Character> seen = new LinkedHashSet<Character>();
    StringBuilder sb = new StringBuilder();
    for (char c : text.toCharArray())
        if (seen.add(c))
            sb.append(c);
    return sb.toString();
}