boolean checkPalindrome(String inputString) {
    String reverseString = "";
    int x = inputString.length();
    for (int i = x - 1; i >= 0; i--)
        reverseString += inputString.charAt(i);
    if (reverseString.equals(inputString))
        return true;
    else
        return false;
}