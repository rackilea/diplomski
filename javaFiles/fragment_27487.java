public static char getMax(String s) {

    char maxappearchar = ' ';
    int counter = 0;
    int[] ascii_count = new int[128];  // fast path for ASCII
    HashMap<Character,Integer> nonascii_count = new HashMap<Character,Integer>();

    for (int i = 0 ; i < s.length() ; i++)
    {
        char ch = s.charAt(i);  // This does appear to be the recommended way to iterate over a String
        // alternatively, iterate over 32bit Unicode codepoints, not UTF-16 chars, if that matters.
        if (ch < 128) {
            ascii_count[ch]++;
        } else {
            // some code to set or increment the nonascii_count[ch];
        }
    }

    // loop over ascii_count and find the highest element
    // loop over the keys in nonascii_count, and see if any of them are even higher.
    return maxappearchar;
}