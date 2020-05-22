void someRandomMethod() {
    Wrapper someWrapperINeed = new Wrapper(new X(blah, blah blah));
    foo(someWrapperINeed);
    someWrapperINeed.clean();

    // Instead of foo(new Wrapper(new X(blah, blah, blah));
}

// Or foo can call clean if the wrapper will never be needed after its invocation
void foo(Wrapper w) {
    bar(w.x());
    w.clean();
}