Thread threadA = new Thread(() -> {
    Example objA = ...;
    setValue(objA, 1);
});
Thread threadB = new Thread(() -> {
    Example objB = ...;
    setValue(objB, 2);
});
threadA.start();
threadB.start();