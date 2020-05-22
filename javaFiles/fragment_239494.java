static String minWinSubStr(String s, String t) {
    System.out.println(s);
    System.out.println(t);

    HashMap<Character, Integer> tabl = new HashMap<>();

    for (char c : t.toCharArray()) {
        int charCount = 0;
        if (tabl.containsKey(c))
            charCount = tabl.get(c);
        tabl.put(c, charCount + 1);
    }

    int begin = 0, end = 0, counter = tabl.size();

    String ans = "";
    int max = s.length();
    while (end < s.length()) {
        char endChar = s.charAt(end);
        if (tabl.containsKey(endChar)) {
            int charCount = tabl.get(endChar);