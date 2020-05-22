@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlCollectionValidator.class)     // will be created below
public @interface URLCollection {
    String message() default "default error message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}