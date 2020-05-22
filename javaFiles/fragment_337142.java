public static void checkPalindrome(int n, int a, int b) {
    String s = "" + n;
    boolean palindrome = false;
    int j = s.length()-1;

    for(int i = 0; i <= j; i++){
        if(s.charAt(i) != s.charAt(j))
            break;
        j --;
    }

    if(palindrome)
        System.out.println(n + ", " + a + ", " + b);
}