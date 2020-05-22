public static List<String> getStrsBetweenBalancedSubstrings(String s, Character markStart, Character markEnd) {
    List<String> subTreeList = new ArrayList<String>();
    int level = 0;
    int lastCloseBracket= 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
            if (c == markStart) {
                    level++;
                    if (level == 1 && i != 0 && i!=lastCloseBracket &&
                        !s.substring(lastCloseBracket, i).trim().isEmpty()) {
                            subTreeList.add(s.substring(lastCloseBracket, i).trim());
                }
            }
        } else if (c == markEnd) {
            if (level > 0) { 
                level--;
                lastCloseBracket = i+1;
            }
            }
    }
    if (lastCloseBracket != s.length() && !s.substring(lastCloseBracket).trim().isEmpty()) {
        subTreeList.add(s.substring(lastCloseBracket).trim());  
    }
    return subTreeList;
}