class Bar1 {
    public static < T > void go( Foo< ? super Foo< T > > f ) {
        // can't properly type the results of any covariant method of f,
        // but we can pass a Foo< T > to any contravariant method of f
    }
}

class Bar2 {
    public static < T > void go( Foo< ? extends Foo< ? extends T > > f ) {
        // can't pass a Foo< T > to a contravariant method of f;
        // can use result r of any covariant method of f;
        // can't pass a T to a contravariant method of r;
        // can use result of covariant method of r
    }
}