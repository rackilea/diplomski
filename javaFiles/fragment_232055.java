public static <T extends Room> T makeRoom(Class<T> roomClass) 
    throws IllegalArgumentException, InstantiationException, 
        IllegalAccessException, InvocationTargetException, 
        SecurityException, NoSuchMethodException{

    // This is enough, if you have 0-arg constructor in all your subclasses
    return roomClass.newInstance();
}