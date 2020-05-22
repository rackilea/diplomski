public static void main( final String[] args ){
    Point[] pts = {
            new Point( 1, 1, 1, "1" ),
            new Point( 2, 2, 2, "2" ),
            new Point( 3, 3, 3, "3" ),
            new Point( 1, 1, 1, "4" ),
            new Point( 4, 4, 4, "2" )
    };

    TreeSet<Point> ps = new TreeSet<Point>();
    for ( Point p : pts )
        ps.add( p );
    System.out.println( ps );
}