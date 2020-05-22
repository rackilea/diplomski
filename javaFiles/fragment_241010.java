public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
    if (annotationClass == null)
        throw new NullPointerException();

    return (T) declaredAnnotations().get(annotationClass);
}