public <X> X getImplementingObject(Class<X> interfaceClass, String className)
   throws ClassNotFoundException, IllegalAccessException, InstantiationException
{
    ClassLoader loader = new DatabaseClassLoader(interfaceClass.getClassLoader(), ...);
    Class<?> cl = loader.loadClass(className);
    Class<? extends X> c = cl.asSubclass(interfaceClass);
    return c.newInstance();
}