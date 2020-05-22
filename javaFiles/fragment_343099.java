@Target({ FIELD, METHOD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AfterTomorrowValidator.class)
@Documented
public @interface AfterTomorrow {
    String message() default "{AfterTomorrow.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}