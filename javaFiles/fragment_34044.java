@Constraint(validatedBy = StateConstraintValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface State {

    String message() default "{State}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};     
}