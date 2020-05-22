public static void main(String[] args) {
    System.out.println(multiplyEvens(4));
}

private static int multiplyEvens(int n) {
    if(n < 1) throw new IllegalArgumentException("Value less than 1 not supported");
    else if(n == 1) return 2;
    else return multiplyEvens(n-1) * (n*2);
}