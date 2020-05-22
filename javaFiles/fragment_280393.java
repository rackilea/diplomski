private static Unsafe getUnsafe() {
    try {
        Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeField.setAccessible(true);
        return (Unsafe)theUnsafeField.get(null);
    }
    catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
    }
    catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }
}