private void callSafe(String something, Boolean flag, Function<SomeClass,ReturnClass> f) {
    try {
        SomeClass check = someFunction(flag, something);
        if (check.IsTrue()) {
            f.apply (check);
        }
    } catch(Exception e) {
        // handle exception
    }
}

public void roo(String something, Boolean flag, Integer id) {
    callSafe(something, flag, (SomeClass check) -> /*some code using check which return an instance of ReturnClass*/);
}