public static <T extends Parent> T load(Class<T> clazz, int id)
    throws IllegalAccessException, InstantiationException {
    T object = clazz.newInstance(); //createInstanceFromClass(className);
    //populate object...
    return object;
}