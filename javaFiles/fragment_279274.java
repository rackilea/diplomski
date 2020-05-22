public static String makePalindrome(String base){
    String pref = "";
    int i = base.length() - 1;
    while(! checkPalindrome(pref + base)){
        pref = pref + base.charAt(i);
        i --;
    }
    return pref + base;
}