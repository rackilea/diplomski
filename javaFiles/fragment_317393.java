if (test) {
    for (A a : listOfA) loopBody(a);
} else {
    for (B b : listOfB) loopBody(b);
}
...
private static <T> void loopBody(T item) {
    ...
}