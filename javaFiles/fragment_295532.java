public static Set<Comparable<?>> common( Comparable<?>[][] a ){
    Set<Comparable<?>> inter = new HashSet<>( Arrays.asList( a[0] ) );
    for( int i = 1; i < a.length; ++i ){
        inter.retainAll( new HashSet<>( Arrays.asList( a[i] ) ) );
    }
    return inter;
}