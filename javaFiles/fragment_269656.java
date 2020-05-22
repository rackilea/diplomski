public boolean checkPalindrome(String text) {
    // remove all whitespace from input word (do this FIRST)
    text = text.replaceAll("\\s+", "");

    // remove optional period from end of input word
    if (text.endsWith(".")) {
        text = text.substring(0, text.length() - 1);
    }

    char[] array = new char[80];
    int length = text.length();

    String reverseText = "";

    for (int i = length-1; i >= 0; i--) {
         reverseText = reverseText + text.charAt(i);
    }

    if (reverseText.equalsIgnoreCase(text)) {
        return true;
    }
    else {
        return false;
    }
}