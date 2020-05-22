private <A extends Annotation> void doValidate(Field field, 
      AnnotatedFieldValidator<A> validator, Annotation a, Object o) {
    // I assume this is correct following only access to validators Map
    // through addValidator()
    A annotation = validator.getSupportedAnnotationClass().cast(a);
    try {
        validator.validate(field, annotation, bean, beanName);
    } catch (IllegalAccessException e) {
    }
}