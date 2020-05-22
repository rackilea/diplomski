private static <T> void scanInstance(Object objectToScan, Class<T> lookingFor, Set<? super Object> scanned, Collection<? super T> results) {
    if (objectToScan == null) {
        return;
    }
    if (! scanned.add(objectToScan)) { // to prevent any endless scan loops
        return;
    }
    // you might need some extra code if you want to correctly support scanning for primitive types
    if (lookingFor.isInstance(objectToScan)) {
        results.add(lookingFor.cast(objectToScan));
        // either return or continue to scan of target object might contains references to other objects of this type
    }
    // we won't find anything intresting in Strings, and it is pretty popular type
    if (objectToScan instanceof String) {
        return;
    }
    // basic support for popular java types to prevent scanning too much of java internals in most common cases, but might cause 
    // side-effects in some cases
    else if (objectToScan instanceof Iterable) {
        ((Iterable<?>) objectToScan).forEach(obj -> scanInstance(obj, lookingFor, scanned, results));
    }
    else if (objectToScan instanceof Map) {
        ((Map<?, ?>) objectToScan).forEach((key, value) -> {
            scanInstance(key, lookingFor, scanned, results);
            scanInstance(value, lookingFor, scanned, results);
        });
    }
    // remember about arrays, if you want to support primitive types remember to use Array class instead.
    else if (objectToScan instanceof Object[]) {
        int length = Array.getLength(objectToScan);
        for (int i = 0; i < length; i++) {
            scanInstance(Array.get(objectToScan, i), lookingFor, scanned, results);
        }
    }
    else if (objectToScan.getClass().isArray()) {
        return; // primitive array
    }
    else {
        Class<?> currentClass = objectToScan.getClass();
        while (currentClass != Object.class) {
            for (Field declaredField : currentClass.getDeclaredFields()) {
                // skip static fields
                if (Modifier.isStatic(declaredField.getModifiers())) {
                    continue;
                }
                // skip primitives, to prevent wrapping of "int" to "Integer" and then trying to scan its "value" field and loop endlessly.
                if (declaredField.getType().isPrimitive()) {
                    return;
                }
                if (! declaredField.trySetAccessible()) {
                    // either throw error, skip, or use more black magic like Unsafe class to make field accessible anyways.
                    continue; // I will just skip it, it's probably some internal one.
                }
                try {
                    scanInstance(declaredField.get(objectToScan), lookingFor, scanned, results);
                }
                catch (IllegalAccessException ignored) {
                    continue;
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }
}