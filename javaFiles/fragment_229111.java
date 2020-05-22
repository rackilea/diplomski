public static void traverseDepthFirst(Object obj) { // May need throws/catch!
    if (obj == null) {
        // ... do something for null ...
        return;
    }
    // ... perhaps do something different for arrays, primitives, String, etc.
    for (
        Class<?> clazz = obj.getClass();
        clazz != null;
        clazz = clazz.getSuperclass()
    ) {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            // ... pre-traversal code ...
            traverseDepthFirst(field.get(obj));
            // ... post-traversal code ...
        }
    }
}