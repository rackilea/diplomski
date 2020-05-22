public static void main( String[] args ) {
    doIt( new int[] {8,16,12,6,6,10,5} );
    doIt( new int[] {0, 45, 25, 40, 38, 20, 10, 32, 25, 18, 30} ); 
    doIt( new int[] {10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1} );
}

public static void doIt( int[] r ) {
    final int[] a= new int[r.length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
        max = Math.max( max, a[i] );
        a[(a.length-1)-i] = r[i];
    }
    final int[] s = new int[max+1];
    for (int i = 0; i < a.length; i++) {
        final int size = a[i];
        s[size]++;
        for (int j = size+1; j < s.length; j++) {
            s[j] = Math.max( s[j-1], s[j] );
        }
        for (int j = 0; j < s.length; j++) {
            System.out.print( " " + ((s[j]) > 9 ? "" : " ") + s[j] );
        }
        System.out.print( " (Best we can do using pieces: " );
        for (int k = 0; k <= i; k++) {
            System.out.print( a[k] + " " );
        }
        System.out.println( ")" );
    }
    System.out.println( "Tallest cake as a height of: " + s[s.length-1] );
}