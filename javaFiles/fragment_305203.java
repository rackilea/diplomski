// Notice the private FooFactory constructor
private FooFactory() {
}

public static FooFactory create() {
    return new FooFactory();
}

public FooFactory withColor( final Color col ) {
    this.color = color;
    return this;
}

public Foo build() {
    return new FooImpl( color, and, all, the, other, parameters, go, here );
}