public static void main (String... args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    URL[] classpath = new URL[0];

    LoggingClassLoader loggingClassLoader = new LoggingClassLoader(classpath, Main.class.getClassLoader());
    Class<?> aClass = loggingClassLoader.loadClass("com.company.project.RealMain");
    Method main = aClass.getMethod("main", args.getClass());
    main.invoke(null);

  }