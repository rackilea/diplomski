static <T extends Foo> Set<T> getObjectsFromClass(Class<T> clazz) {
    Set<T> objectsFromClass = new HashSet<>();
    for (Foo value: hashSet) {
        if (clazz.isInstance(value)) {
            objectsFromClass.add(clazz.cast(value));
        }
    }
    return objectsFromClass;
}