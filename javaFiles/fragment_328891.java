public static List<String> getBalancedSubstrings(String s, Character markStart, 
                                     Character markEnd, Boolean includeMarkers) {
    List<String> subTreeList = new ArrayList<String>();
    int level = 0;
    int lastOpenBracket = -1;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == markStart) {
            level++;
            if (level == 1) {
                lastOpenBracket = (includeMarkers ? i : i + 1);
            }
        }
        else if (c == markEnd) {
            if (level == 1) {
                subTreeList.add(s.substring(lastOpenBracket, (includeMarkers ? i + 1 : i)));
            }
            if (level > 0) level--;
        }
    }
    return subTreeList;
}