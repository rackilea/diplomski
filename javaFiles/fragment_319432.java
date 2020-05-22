/**
 * Validate the model attribute if applicable.
 * <p>The default implementation checks for {@code @javax.validation.Valid}.
 * @param binder the DataBinder to be used
 * @param parameter the method parameter
 */
protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
    Annotation[] annotations = parameter.getParameterAnnotations();
    for (Annotation annot : annotations) {
        if (annot.annotationType().getSimpleName().startsWith("Valid")) {
            Object hints = AnnotationUtils.getValue(annot);
            binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
            break;
        }
    }
}