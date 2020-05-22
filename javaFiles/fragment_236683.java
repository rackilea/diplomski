boolean isInstance(Object o, String className) {
    try {
        Class clazz = Class.forName(className);
        return clazz.isInstance(o);
    } catch (ClassNotFoundException ex) {
        return false;
    }
}