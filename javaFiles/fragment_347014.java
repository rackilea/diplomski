public static List<String> getBalancedStr(String s, String strBefore, Character markStart, 
                                 Character markEnd, Boolean includeMarkers) {
    Matcher m = Pattern.compile("(?=(\\b\\Q" + strBefore + markStart.toString() + "\\E.*))").matcher(s);
    List<String> subTreeList = new ArrayList<String>();
    while (m.find()) {
        int level = 0;
        int lastOpenBracket = -1;
        for (int i = 0; i < m.group(1).length(); i++) {
            char c = m.group(1).charAt(i);
            if (c == markStart) {
                level++;
                if (level == 1) {
                    lastOpenBracket = (includeMarkers ? i : i + 1);
                }
            }
            else if (c == markEnd) {
                if (level == 1) {
                    if (includeMarkers) {
                        subTreeList.add(strBefore + m.group(1).substring(lastOpenBracket, i + 1));
                    } else {
                        subTreeList.add(m.group(1).substring(lastOpenBracket, i));
                    }
                    break;
                }
                level--;
            }
        }
    }
    return subTreeList;
}