private Object[] createArray(String fullClassName, int length) {
    Object[] objects = new Object[length];
    try {
        Class c = Class.forName(fullClassName);
        for (int i = 0; i < objects.length; i++) {
            objects[i] = c.newInstance();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InstantiationException e) {
        e.printStackTrace();
    }
    return objects;
}