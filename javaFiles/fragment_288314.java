public enum ImplicitType {
    DO_NOT_USE;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyAnnotation {

    Class<? extends Enum<?>> clazz() default ImplicitType.class;

    String value();
}

@MyAnnotation("A"); 
private MyEnumType myEnumField;