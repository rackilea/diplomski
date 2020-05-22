class MySupplier<T> implements Supplier<T> {
    private T s;
    public MySupplier( T s ) {
        this.s = s;
    }
    public T get() {
        System.out.println( String.format( "Lazy loading '%s'", s ) );
        return s;
    }
}

public void lazyLoad() {
    List<MySupplier<String>> list = Lists.newArrayList( new MySupplier<String>( "a" ), new MySupplier<String>( "a" ), new MySupplier<String>( "b" ), new MySupplier<String>( "c" ), new MySupplier<String>( "d" ) );

    for ( Iterator<String> i = supplierIterator( list ); i.hasNext(); ) {
        System.out.println( i.next() );
    }
}

public static <T> Iterator<T> supplierIterator( Collection<? extends Supplier<T>> c ) {
    Function<Supplier<T>, T> function = Suppliers.supplierFunction();
    Iterable<T> iterable = Iterables.transform( c, function );
    return iterable.iterator();
}