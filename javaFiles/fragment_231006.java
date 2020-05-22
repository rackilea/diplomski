private static int foo;

public void bar() {
    ...
    foo = someMethod();
    ...
    baz();
}

private void baz() {
   ...
   someOtherMethod(foo);
   ...
}