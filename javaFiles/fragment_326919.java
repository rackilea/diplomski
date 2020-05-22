private static <T> T findAnnotationValue(Element element, String annotationClass,
        String valueName, Class<T> expectedType) {
    T ret = null;
    for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
        DeclaredType annotationType = annotationMirror.getAnnotationType();
        TypeElement annotationElement = (TypeElement) annotationType
                .asElement();
        if (annotationElement.getQualifiedName().contentEquals(
                annotationClass)) {
            ret = extractValue(annotationMirror, valueName, expectedType);
            break;
        }
    }
    return ret;
}

private static <T> T extractValue(AnnotationMirror annotationMirror,
        String valueName, Class<T> expectedType) {
    Map<ExecutableElement, AnnotationValue> elementValues = new HashMap<ExecutableElement, AnnotationValue>(
            annotationMirror.getElementValues());
    for (Entry<ExecutableElement, AnnotationValue> entry : elementValues
            .entrySet()) {
        if (entry.getKey().getSimpleName().contentEquals(valueName)) {
            Object value = entry.getValue().getValue();
            return expectedType.cast(value);
        }
    }
    return null;
}