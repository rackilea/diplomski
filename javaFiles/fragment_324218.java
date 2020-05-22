public String plusOut(String str, String word) {
    String newString = "";
    // iterate up to length() to catch the last char if word.length() is 1
    for (int i = 0; i < str.length(); i++) {
        // use min() to avoid an IndexOutOfRange
        String sub = str.substring(i, Math.min(i+word.length(), str.length()));
        if (sub.equals(word)) {
            newString = newString + sub;
            // skip remaining characters of word
            i += sub.length()-1;
        }
        else {
            newString = newString + "+";
        }
    }
    return newString;
}