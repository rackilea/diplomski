private static Short getValue(Field f) {
    try {
        return f.getShort(null);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}