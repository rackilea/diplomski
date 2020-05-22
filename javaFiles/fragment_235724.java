public static <T> T createInstanceFrom(T myInstance) {
    @SuppressWarnings("unchecked")
    Class<T> myType = (Class<T>) myInstance.getClass();
    T instance = myType.newInstance();
    return instance;
}