public static void main(final String[] args) {
    long total = 0;
    long term = 1;
    for( int i = 0; i < 5; i++ ) {
        term += (2*i);
        total += term;
        System.out.println("Term " + i + " is " + term);
        System.out.println("Current Total is " + total);
    }
}