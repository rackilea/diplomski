boolean checkPalindrome(String inputString) {
    String reverseString = "";
    int x = inputString.length();
    int b = x;
    for (int i = 0; i < x; i++) {
        char a = inputString.charAt(b);
        b--;
        reverseString = reverseString + a;
    }
    if (reverseString.equals(inputString))
        return true;
    else
        return false;
}