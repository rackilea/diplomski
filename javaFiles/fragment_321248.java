Reflections reflections = new Reflections("com.mypackage.root", new MethodAnnotationsScanner());

Set<Method> methods = reflections
        .getMethodsAnnotatedWith(MyAnnotation.class).stream()
        .filter(method -> method.getDeclaringClass().getPackage().getName().matches("com.mypackage.root.*.deep"))
        .collect(Collectors.toSet());