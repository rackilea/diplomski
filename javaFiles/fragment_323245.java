@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidQueryRangeValidator.class })
@Documented
public @interface ValidQueryRange {

    String message() default "{error}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}