@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { MethodAndInstrumentsValidator.class })
@Documented
public @interface ValidMethodAndInstruments {
    String message() default "{my.package.MethodAndInstruments.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}