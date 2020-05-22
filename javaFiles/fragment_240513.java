Reflections reflections = new Reflections("my.package.name");
    Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(MakeJson.class);
    for (Class<?> annotated : annotatedClasses) {
        if  (annotated.isEnum()) {
            Jsonify j = annotated.getAnnotation(MakeJson.class);
            Object[] constants = annotated.getEnumConstants();
            Method m = annotated.getMethod(j.label()); // get the method name
            for (Object constant : constants) {
                System.out.println(constant.toString());
                System.out.println(m.invoke(constant));
                // construct json object here
            }
        }
    }