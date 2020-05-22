.flatMap(foo -> {
    Stream<Type> s = foo.bar();
    try {
        anotherOperation();
    } catch(Throwable t) {
        try(s) { throw t; } // close and do addSuppressed if follow-up error
    }
    return s;
})