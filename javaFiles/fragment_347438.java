TIntObjectMap<String> map = new TIntObjectHashMap<>();
map.put( 1, "a" );
map.put( 2, "b" );

AtomicInteger found = new AtomicInteger( -1 );
map.forEachEntry( new TIntObjectProcedure<String>() {
    @Override
    public boolean execute( int key, String value ) {
        if ( value.equals( "a" ) ) {
            found.set( key );
            return false;
        }
        return true;
    }
} );
System.out.println( "Found: " + found.get() );