public static TypeThing buildMyThing(TypeA a, TypeB b, TypeC c) {
    if (c.getData() == null) throw new IllegalArgumentException("");
    return new TypeThing(a, b, c.getOtherData());
}

public Constructor(TypeA a, TypeB b, TypeD d) {
    // stuff happens
}