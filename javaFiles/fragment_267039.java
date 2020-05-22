class Foo<T> {
    public <V> V bar(V v) { return v; }
}

//compiles
Foo<Object> foo = new Foo<Object>();
Integer i = foo.bar(1);

//compiles
Foo<?> foo = new Foo<String>();
Integer i = foo.bar(1);

// fails
Foo foo = new Foo();
Integer i = foo.bar(1); // error: Object cannot be converted to Integer