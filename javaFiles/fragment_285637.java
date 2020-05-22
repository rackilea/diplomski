@NotNull()
@NotBlank()
@Constraint(validatedBy = ValidStringValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface ValidString {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Size size() default @Size(/*enter default size arguments here*/);