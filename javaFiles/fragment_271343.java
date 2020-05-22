try {
    Class clazz = Class.forName("Foo");
    Method method = clazz.getMethod("saySomething");
    Object obj = clazz.newInstance();
    method.invoke(obj);
 } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
 }