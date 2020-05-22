Object foo = new Foo();

@SuppressWarnings("unchecked")
public <T> T getFoo(Class<T> clazz) {
    return (T) foo;
}

...

Foo f = getFoo(Foo.class);