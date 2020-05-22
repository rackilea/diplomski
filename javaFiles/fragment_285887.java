public static int findPattern(List<String> strings, String... pattern) {
    findFirstString:
    for (int startIndex = 0; startIndex <= strings.size() - pattern.length; startIndex++) {
        for (int i = 0; i < pattern.length; i++) {
            String p = pattern[i];
            if (!"*".equals(p) && !strings.get(startIndex + i).equals(p)) {
                continue findFirstString;
            }
        }
        return startIndex;
    }
    return -1;
}