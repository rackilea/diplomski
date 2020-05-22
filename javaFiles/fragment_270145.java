public static String shortestPalindrome(String myString) {
    String finalResult = "";
    String temp = "";
    String rev = "";
    for (int i = myString.length() - 1; i >= 0; i--) {
        rev += myString.charAt(i);
        temp = rev + myString;
        if (check(temp) == true) {
            finalResult = temp;
            break;
        }
    }
    return finalResult;
}