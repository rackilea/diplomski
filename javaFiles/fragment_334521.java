public void validate(Object o) {
  Field[] fields = getFields(o.getClass());
  for (Field field : fields) {
    Annotation[] annotations = field.getAnnotations();
    for (Annotation annotation : annotations) {
      AnnotatedFieldValidator<? extends Annotation> validator = 
          validators.get(annotation.annotationType());
      if (validator != null) {
        doValidate(field, validator, annotation, o);
      }
    }
  }
}