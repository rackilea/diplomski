public StaticClass toNashornClass(Class<?> c) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

    Class<?> cl = Class.forName("jdk.internal.dynalink.beans.StaticClass");

    Constructor<?> constructor = cl.getDeclaredConstructor(Class.class);

    constructor.setAccessible(true);
    StaticClass o = (StaticClass) constructor.newInstance(c);

    return o;
}