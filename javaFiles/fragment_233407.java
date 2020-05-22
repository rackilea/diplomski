class Bar0 {
    public static < T > void go( Foo< Foo< ? extends T > > f ) {
        // can pass a Foo< T > to a contravariant method of f;
        // can use any result r of any covariant method of f,
        // but can't pass T to any contravariant method of r
    }
}