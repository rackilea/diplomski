public static <T extends Foo> FooParser<T> getFooParser(Class<T> cls) {
//            ^^^^^^^^^^^^^^^           ^                     ^
//            introduce a type       now these two are "compatible"
//            variable
    initParsers();

    // This line will however require a cast. Judge for yourself if it is safe.
    FooParser<T> parser = (FooParser<T>) fooParsers.get(cls);
    if (parser == null) {
        throw new RuntimeException("FooParser not found for class " + cls);
    }
    return parser;
}