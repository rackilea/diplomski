public static int charRunCount(String str, char c) {
    char last = 0;
    int counter = 0;
    for (int i = 0; i < str.length(); i++) {
        // whenever a run starts.
        if (last != c && str.charAt(i) == c)
            counter++;
        last = str.charAt(i);
    }
    return counter;
}