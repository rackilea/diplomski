@ConstraintComposition(OR)
@Pattern(regexp = ".+@.+")
@Pattern(regexp = "\+\d+")
@ReportAsSingleViolation
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
public @interface EmailOrPhone {