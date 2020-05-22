public static ArrayList<String> GetSubstrings(String str) {

    // set up any substring and add it to the ArrayList
    ArrayList<String> subStrings = new ArrayList();
    for (int i = 0; i < str.length(); ++i) {
        for (int j = 1; j <= str.length() - i; ++j) {
            subStrings.add(str.substring(i, i + j));
        }
    }

    return subStrings;
}