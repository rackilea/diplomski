public <M extends A> void doSomething(Class<M> mClass, M mObject) {
    // ... Do something with mObject.

    A object = getObject();
    Class<? extends A> objectClass = object.getClass();
    privateSomething(objectClass, object);
}
private <T extends A> void privateSomething(Class<T> objectClass, A object) {
    doSomething(objectClass, objectClass.cast(object)); // Should compile.
}