Collection< T > collection = ...;

List< T > list = new ArrayList< T >( collection );

Collections.sort( list );
 // or
Collections.sort( list, new Comparator< T >( ){...} );

// list now is sorted