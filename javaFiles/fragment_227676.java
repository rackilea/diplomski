public static boolean isPalindrome(String test) {
    if(test.length() <= 1) { // A more elegant check
        return true;
    } 

    if (test.charAt(0) == test.charAt(test.length() - 1)) {
        // "return" was missing here
        return isPalindrome(test.substring(1, test.length() -1)) ;      
    } 
    return false;
}