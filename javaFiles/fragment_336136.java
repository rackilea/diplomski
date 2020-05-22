public boolean isPalindrome(String str) {
    if(str == null)
        return false;

    str = str.toLowerCase();

    for(int i = 0, j = str.length() - 1; i < j; i++, j--)
        if(str.charAt(i) != str.charAt(j))
            return false;

    return true;
}