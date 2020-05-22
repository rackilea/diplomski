@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {

  String  name(); // mandatory

  Class<InstanceConverter> converter() default InstanceConverter.class; // optional
}