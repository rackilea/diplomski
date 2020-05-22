public static void traverseDepthFirst(Object obj) { // May need throws/catch!
    if (obj == null) {
        // ... do something for null ...
        return;
    }
    // ... perhaps do something different for arrays, primitives, String, etc.
    for (Field field : obj.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        // ... pre-traversal code ...
        traverseDepthFirst(field.get(obj));
        // ... post-traversal code ...
    }
}