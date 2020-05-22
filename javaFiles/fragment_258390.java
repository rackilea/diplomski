public Foo( Bar bar, Baz baz ) {
    // do stuff
}
public Foo( Bar bar ) {
    this( bar, new Baz() );
}
public Foo( Bar bar, boolean flag) {
    this( bar, new Baz(flag) );
}