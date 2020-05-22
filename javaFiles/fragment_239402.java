@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UrlValidatorImplementation.class)
public @interface UrlValidator{
    String message() default "Invalid url";
}