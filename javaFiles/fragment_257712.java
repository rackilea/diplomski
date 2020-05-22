public static <T extends Parent> T load(Class<T> clazz, int id) {
    try {
        T object = clazz.newInstance(); //createInstanceFromClass(className);
        //populate object...
        return object;
    } catch (IllegalAccessException | InstantiationException e) {
        //handle the exception here...
    }
    return null;
}