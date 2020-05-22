private static String substituteByOffset(String text, List<Pair<String, Pair<Integer, Integer>>> mentions) {
    int offset = 0;
    for (Pair<String, Pair<Integer, Integer>> entry : mentions) {
        String subst = entry.first;
        Pair<Integer, Integer> offsets = entry.second;
        Integer lower = offsets.first;
        Integer upper = offsets.second;
        text = text.substring(0, lower + offset) + subst + text.substring(upper + offset, text.length());
        offset = subst.length() - (upper - lower) + offset;
    }
    return text;
}