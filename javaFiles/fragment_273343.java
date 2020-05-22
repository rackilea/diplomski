public static Supplier getter(Object obj, Field f) {
    return () -> {
        try {
            return f.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    };
}