public static void main(String[] args) {
    for(int i= 2 ; i <= 100 ; i++ ) {
        System.out.print("Factors of " + i + ": ");
        int limit= (int)Math.sqrt(i) ;
        for(int j= 2 ; j <= limit ; j++ )
            if( i % j == 0 ) {
                System.out.print( j + " " );
                System.out.print( (i/j) + " " );
            }
        System.out.println();
    }
}