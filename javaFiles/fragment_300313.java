public static <T extends BaseClass> T newObject(Class<T> classOfT, String someName) {
    try {
        return classOfT.getConstructor(SomeClass.class)
                       .newInstance(new SomeClass(someName));
    } catch (Exception e) {
         throw new SomeException("Failed to create " + classOfT, e);
    }
}