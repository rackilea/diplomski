public static void main( String[] args) {
        String line="a,b,a,b,a,b";
        String[] split = line.split( "," );
        Arrays.sort( split );
        for ( int i = split.length -1; i > 0 ; i--) {
            System.out.print( split[i] );
            System.out.print( "," );
        }
        System.out.print( split[0] );
    }