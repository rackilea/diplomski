private static <T extends AccessibleObject> void applyPredicateForFields(List<T> objects, 
                    T object, Predicate<T> predicate){
    if (predicate == null || predicate.apply(object)) {
        if (!object.isAccessible())
            object.setAccessible(true);
        objects.add(object);
    }
}