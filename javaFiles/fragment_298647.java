public static ArrayList<String> stringToTokens(String s) {
    ArrayList<String> al = new ArrayList<String>();
    StringBuilder word = new StringBuilder();
    boolean inWord = !s.isEmpty() && Character.isLetter(s.charAt(0));
    for (int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isLetter(c)) {
            word.append(c);
        } else if (inWord) {
            if (word.length() > 0) {
                al.add(word.toString());
                word.setLength(0);
            }
            al.add(""+c);
        } else {
            al.add(""+c);
        }
    }
    if (word.length() > 0) {
        al.add(word.toString());
    }
    return al;
}

public static String longestCommonWithWords(String sa, String sb) {
    ArrayList<String> a = stringToTokens(sa);
    ArrayList<String> b = stringToTokens(sb);
    int m[][] = new int[a.size()][b.size()];
    int bestLength = 0;
    HashSet<Integer> bestSet = new HashSet<Integer>();
    for (int i=0; i<a.size(); i++) {
        for (int j=0; j<b.size(); j++) {
            if (a.get(i).equals(b.get(j))) {
                m[i][j] = (i==0 || j==0) ? 1 : m[i-1][j-1]+1;
                if (m[i][j] > bestLength) {
                    bestLength = m[i][j];
                    bestSet.clear();
                    bestSet.add(i);
                } else if (m[i][j] == bestLength) {
                    bestSet.add(i);
                }
            } else {
                m[i][j] = 0;
            }
        }
    }
    // return first result (or empty string if none)
    StringBuilder result = new StringBuilder();
    if (bestLength > 0) {
        int end = bestSet.iterator().next();
        int start = end - bestLength;
        for (int i=start; i<end; i++) {
            result.append(a.get(i+1));
        }
    }
    return result.toString();
}