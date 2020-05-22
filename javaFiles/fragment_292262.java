@Constraint(validatedBy = { ReminderValidator.class, PendingValidator.class } )
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidator{
    String message() default "{error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}