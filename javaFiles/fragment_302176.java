@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@NotEmpty
@Length(min = 2, max = 35)
public @interface MyAnnotation {

    public abstract String message() default "{mypropertykey}";

    public abstract Class<?>[] groups() default {};

    public abstract Class<?>[] payload() default {};
}