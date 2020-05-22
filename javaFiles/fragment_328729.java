...
 static {
        try {
            Thread.currentThread().setContextClassLoader(SomeClass.class.getClassLoader());
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
...