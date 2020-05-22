private void callSafe(String something, Boolean flag, Consumer<SomeClass> c) {
    try {
        SomeClass check = someFunction(flag, something);
        if (check.IsTrue()) {
            c.accept (check);
        }
    } catch(Exception e) {
        // handle exception
    }
}

public void roo(String something, Boolean flag, Integer id) {
    callSafe(something, flag, (SomeClass check) -> /*some code using check*/);
}