@Documented
@Constraint(validatedBy = MeasurementValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidMeasurementInput {

    String message() default "Invalid measurement input";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}