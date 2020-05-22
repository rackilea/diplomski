public static List<String> replaceInBalancedSubstrings(String s, Character markStart, Character markEnd, String old_key, String new_key) {
    List<String> subTreeList = new ArrayList<String>();
    int level = 0;
    int prevStart = 0;
    StringBuffer sb = new StringBuffer();
    int lastOpenBracket = -1;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (level == 0) {
            sb.append(c);
        }
        if (c == markStart) {
            level++;
            if (level == 1) {
                lastOpenBracket = i;
                if (sb.length() > 0) {
                    subTreeList.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        else if (c == markEnd) {
            if (level == 1) {
                subTreeList.add(s.substring(lastOpenBracket, i+1).replace(old_key, new_key)); // String replacement here
            }
            level--;
        }
    }
    if (sb.length() > 0) {
        subTreeList.add(sb.toString());
    }
    return subTreeList;
}