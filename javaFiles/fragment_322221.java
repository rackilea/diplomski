String[] arr = { "foo", "bar", "foobar" };

    int max = 0;

    for( String s : arr ) {
        if( s.length() > max ) {
            max = s.length();
        }
    }

    for( String s : arr ) {
        System.out.printf(  ">%" + max + "s<%n", s );
    }

    Random random = new Random( System.currentTimeMillis() );
    // just to settle the question of whether it works when 
    // Java can't know ahead of time what the value will be
    max = random.nextInt( 10 ) + 6;

    for( String s : arr ) {
        System.out.printf(  ">%" + max + "s<%n", s );
    }
}