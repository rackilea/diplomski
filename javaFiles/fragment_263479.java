public static void main(String[] args) {
    int n = (int) factorial(4);
    for ( int i = 0; i < n; i++ ) {
      System.out.format( "%d: %s\n", i, Arrays.toString( perm(i, 1, 4 ) ) );
    }
}