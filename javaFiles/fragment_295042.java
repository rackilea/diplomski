List<Exception> exceptions = new ArrayList<Exception>();
for (Foo foo : foos) {
    try {
        doStuff(foo);
    } catch (FooException ex) {
        exceptions.add(ex);
    }
}