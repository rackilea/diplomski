// Returns annotation from method or class (if does not exist, returns null)
@SuppressWarnings({ "unchecked", "rawtypes" })
protected Object getAnnotationClass(Class clazz, InvocationContext ctx){
    Object annotationClass = ctx.getMethod().getAnnotation(clazz);

    // Try to find annotation on class level
    if(annotationClass == null){
        annotationClass = ctx.getTarget().getClass().getSuperclass().getAnnotation(clazz);
    }

    return annotationClass;
}