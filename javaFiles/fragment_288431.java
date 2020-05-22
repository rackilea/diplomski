class BaseClass< T > {
    void baseFunc1( T foo ) { }
    void baseFunc2( Collection< ? extends T > foo ) {
        // use foo in covariant fashion,
        // e.g., foo.contains( t ) 
        // can accept Collection< T >, Collection< S > (where S <: T)
    }
    void baseFunc3( Collection< ? super T > foo ) {
        // use foo in contravariant fashion,
        // e.g., foo.add( t )
        // can accept Collection< T >, Collection< S > (where S >: T)
    }
    void baseFunc4( Collection< T > foo ) {
        // use foo in invariant fashion,
        // e.g., foo.add( foo.iterator().next() )
        // can only accept Collection< T >
    }
}