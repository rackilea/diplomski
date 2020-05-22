package my.thirdparty.application;

public class Foo {
    void blah() {
        zot();
    }

    void foo() {}

    void zot() {
        foo();
    }
}