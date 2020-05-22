interface HasMethodA {
    void method_a();
}

...

class ... {

    <T extends HasMethodA> ... (..., T hasMethodA, ...) {
        ...
        hasMethodA.method_a();
        ...
    }

}