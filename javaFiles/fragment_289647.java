@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {InvoiceAddressValidator.class })
public @interface InvoiceAddressChecker {
    String message() default "Invoice address incorrect.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}