class A {
    int foo;
}
class B extends A {
    int foo;
}
class C extends B {
    {
        ((A)this).foo=42;
    }
}