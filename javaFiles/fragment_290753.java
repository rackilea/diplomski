public void foo1(String bar) {
    String s = decode(par);
}

public void foo2(String bar) {
    Integer s = decode(par);
}

<T> T decode(String serializedRepresentation) {
    Object inflatedObject;

    // logic to unserialize object

    return (T)inflatedObject;
}