static boolean isPerfectSquare(int input) {
    int SquareRoot = (int) Math.sqrt(input);
    return ((SquareRoot * SquareRoot) == input);
}

static boolean isPalindrome(int input) {
    String str = Integer.toString(input);
    return new StringBuffer(str).reverse().toString().equals(str);
}