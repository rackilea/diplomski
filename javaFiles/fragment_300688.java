Foo foo = getFoo();
int result = 0;
if (foo.getClass().equals(Bar.class)) {
    result = 1+1;
} else of (foo.getClass().equals(Baz.class)) {
    result = 2+2;
}