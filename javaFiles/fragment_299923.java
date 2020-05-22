@Documented
@Constraint(validatedBy = ValidJsonValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidJsonConstraint {

  String message() default "Invalid JSON";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}