@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EitherOrValidator.class})
public @interface EitherOr {

    String message() default "A city can only be linked to a country or a province.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}