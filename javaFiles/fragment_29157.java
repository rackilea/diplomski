/**
 * @since 1.5
 */
public Annotation[] getAnnotations() { 
    initAnnotationsIfNecessary();
    return AnnotationParser.toArray(annotations);
}

/**
 * @since 1.5
 */
public Annotation[] getDeclaredAnnotations()  {
    initAnnotationsIfNecessary();
    return AnnotationParser.toArray(declaredAnnotations);
}