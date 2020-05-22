Method[] methods = classObject.getClass().getMethods();

    for (Method method : methods) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }