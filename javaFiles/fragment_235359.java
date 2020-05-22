private void doSomethingMoreComplex(A a) { // a is actually C
    if (a instanceof B) {
        Utils.doSomething((B) a);
    } else {
        Utils.doSomething(a);
    }
}