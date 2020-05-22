private static Class getClass(String clazz) throws ClassNotFoundException {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      if(loader == null)
         loader = YourSingleton.class.getClassLoader();
      return (loader.loadClass(clazz));
   }
}