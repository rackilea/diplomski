@ConstraintComposition(OR)
@Pattern(regexp = "[a-z]")
@Size(min = 2, max = 3)
@ReportAsSingleViolation
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
public @interface PatternOrSize {

    String message() default "...";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    @OverridesAttribute(constraint=Size.class, name="min")
    int min() default 0;

    @OverridesAttribute(constraint=Size.class, name="max")
    int max() default Integer.MAX_VALUE;

    @OverridesAttribute(constraint=Pattern.class, name="regexp")
    String regexp();
}