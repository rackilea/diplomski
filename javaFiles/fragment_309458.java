public Set<Foo> getObjectsFromClass(Class<? extends Foo> clazz) {
    Set<Foo> objectsFromClass = new HashSet<>();
    for (Foo value: hashSet) {
        if (clazz.isInstance(value)) {
            objectsFromClass.add(value);
        }
    }
    return objectsFromClass;
}