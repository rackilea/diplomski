static <T extends Annotation> T seekAnnotation(Class<T> annotationClass) {
    T annotation = null;
    try {
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            T found = seekAnnotation(annotationClass, ste);
            if (found != null) {
                annotation = found;
            }
        }
    } catch (Exception e) {
        //
    }
    return annotation;
}

static <T extends Annotation> T seekAnnotation(Class<T> annotationClass, StackTraceElement ste) {
    T annotation = null;
    try {
        Class<?> claz = Class.forName(ste.getClassName());
        Method method = claz.getDeclaredMethod(ste.getMethodName());
        annotation = method.getAnnotation(annotationClass);
    } catch (Exception e) {
        //
    }
    return annotation;
}