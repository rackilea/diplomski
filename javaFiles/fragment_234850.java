public String encrypt(String text, final String key) {
    // we assume the key is all lower case
    // and only inputs are letters and space (could enhance to leave all else alone)
    int a_num = (int) 'a'; //unused?
    int A_num = (int) 'A';//unused?
    String output = "";

    for (int i = 0, j = 0; i < text.length(); i++) {
        int cur = (int) text.charAt(i);

        // check for spaces
        if (text.charAt(i) == ' ') {
            output += " ";
        }
        // check for lowercase
        else if (cur >= 'a' && cur <= 'z') {
            output += Character.toString((char) ((cur + key.charAt(j) - 2 * 'a') % 26 + 'a'));
            j = ++j % key.length();
        }
        // should work for uppercase between 'A' and 'Z'
        else {
            output += Character.toString((char) ((cur -'A' + key.charAt(j) - 'a') % 26 + 'A'));
            j = ++j % key.length();
        }
    }
    return output;
}