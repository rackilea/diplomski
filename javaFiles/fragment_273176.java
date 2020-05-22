public static Map<Character,Integer> openFileAndCount() {
    Map<Character,Integer> res = new HashMap<Character,Integer>();
    BufferedReader reader = new BufferedReader(new FileReader("xWords.txt"));
    String s;
    while((s = reader.readLine()) != null) {
        for (int i = 0 ; i != s.length() ; i++) {
            char c = s.charAt(i);
            // The check below lets through all letters, not only Latin ones.
            // Use a different check to get rid of accented letters
            // e.g. è, à, ì and other characters that you do not want.
            if (!Character.isLetter(c)) {
                c = ' ';
            }
            res.put(c, res.containsKey(c) ? res.get(c).intValue()+1 : 1);
        }
    }
    return res;
}