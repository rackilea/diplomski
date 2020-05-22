public static int lengthLongestPath(String input) {
    if (input.length() == 0)
        return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int maxLength = 0;
    String[] paths = input.split("\n");
    for (String path : paths) {
        String dirOrFile = path.replaceFirst("\\t*", "");
        int level = path.lastIndexOf("\t") + 1;

        int prefixLength = 0;
        if (level > 0) {
            prefixLength = map.get(level - 1);
        }

        int pathLength = prefixLength + dirOrFile.length();
        if (dirOrFile.contains(".")) {
            maxLength = Math.max(pathLength + level, maxLength);
        }
        map.put(level, pathLength);
    }
    return maxLength;
}