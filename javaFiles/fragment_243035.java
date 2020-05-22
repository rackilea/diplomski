private String doSomething(MyObject obj) {
    return Optional.ofNullable(myObj)
        .map(MyObject::getA)
        .map(MyObject::getB)
        .map(MyObject::getC)
        .orElseThrow(() -> new IllegalArgumentException("Error message..."));
}