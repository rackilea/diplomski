try {
    Class<?> c = loader.loadClass("Hidden"); // create instance of Class class referring Hidden class using your class loader object
    Object t = c.newInstance();// create instance of your class

    Method[] allMethods = c.getDeclaredMethods();
    for (Method m : allMethods) {// get methods
    String mname = m.getName();// get method name

    try {
        m.setAccessible(true);
        m.invoke();//change as per method return type and parameters
    } catch (InvocationTargetException x) {
          // code here
    }
    }

    // production code should handle these exceptions more gracefully
} catch (ClassNotFoundException x) {
    x.printStackTrace();
} catch (InstantiationException x) {
    x.printStackTrace();
} catch (IllegalAccessException x) {
    x.printStackTrace();
}