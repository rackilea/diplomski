for (Element element : roundEnv.getElementsAnnotatedWith(MyAnnotation.class)) {
    MyAnnotation myAnnotation = element.getAnnotation(MyAnnotation.class);
    if (myAnnotation != null) {
        doSomething(myAnnotation, element);
    }
}

for (Element element : roundEnv.getElementsAnnotatedWith(MyMethodAnnotation.class)) {
    MyMethodAnnotation myMethodAnnotation = element.getAnnotation(MyMethodAnnotation.class);
    if (myMethodAnnotation != null) {
        doSomething(myMethodAnnotation, element);
    }
}