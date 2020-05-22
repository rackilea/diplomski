if (thing instanceof ObjectType) {
    performOperations((ObjectType) thing);
}
...

private void performOperations(ObjectType thing) {
    thing.operation1();
    thing.operation2();
    thing.operation3();
}