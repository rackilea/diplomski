Class aClass;
ClassLoader classLoader = test.class.getClassLoader();
try {
    aClass = classLoader.loadClass(fullClassName);
   } catch (ClassNotFoundException e) {
   e.printStackTrace();
 }