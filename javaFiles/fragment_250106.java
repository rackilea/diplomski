String s = "0xff80CBC4";
    int a = Integer.parseInt( s.substring( 2, 4 ), 16 );
    int r = Integer.parseInt( s.substring( 4, 6 ), 16 );
    int g = Integer.parseInt( s.substring( 6, 8 ), 16 );
    int b = Integer.parseInt( s.substring( 8, 10 ), 16 );
    int argb = a << 24 | r << 16 | g << 8 | b;
    System.out.printf( "%2x %2x %2x %2x %8x\n", a, r, g, b, argb );