@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AllStringsRegexValidator.class)
@Documented
public @interface AllStringsRegex {
    String message() default "String not regex";
    String value() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}