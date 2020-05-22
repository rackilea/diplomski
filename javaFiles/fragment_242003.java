public boolean doesMatch(String str1, String str2) {
    if (str1.length() != str2.length())
        return false;
    for (int i = 0; i < str1.length(); i++)
        if (str1.charAt(i) != 'x' && str1.charAt(i) != str2.charAt(i))
            return false;
    return true;
}