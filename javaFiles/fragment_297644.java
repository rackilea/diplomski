public @interface Foos {
    Foo[] value();
}

@Foos({@Foo(bar="one"), @Foo(bar="two")})
public void haha() {}