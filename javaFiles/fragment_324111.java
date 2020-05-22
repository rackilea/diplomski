public static void main(String[] args) {
    String t = "abbcde";
    String s = "xxxyzzzz";
    String result = "";

    int tNextIndex = 0;
    int sNextIndex = 0;

    /* alternate while both strings have characters left */
    while (tNextIndex < t.length() && sNextIndex < s.length()) {
        char tPreviousChar = t.charAt(tNextIndex++);
        result += tPreviousChar;
        while (tNextIndex < t.length() &&  t.charAt(tNextIndex) == tPreviousChar){
            result += tPreviousChar;
            tNextIndex++;
        }

        char sPreviousChar = s.charAt(sNextIndex++);
        result += sPreviousChar;
        while (sNextIndex < s.length() &&  s.charAt(sNextIndex) == sPreviousChar){
            result += sPreviousChar;
            sNextIndex++;
        }   
    }

    /* if either of the string was finished, add the remainder of the other one to the result */
    while (tNextIndex < t.length()) {
        result += t.charAt(tNextIndex++);
    }
    while (sNextIndex < s.length()) {
        result += s.charAt(sNextIndex++);
    }
    System.out.println(result);
}