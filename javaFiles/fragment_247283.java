@ConstraintComposition(OR)
@Constraint1
@Constraint2
@ReportAsSingleViolation
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
public @interface Constraint1ORConstraint2 {
   String message() default "{Constraint1ORConstraint2.message}";
   Class<?>[] groups() default { };
   Class<? extends Payload>[] payload() default { };
}