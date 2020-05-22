@Constraint(validatedBy = {CustomValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomValidation {


      String message() default "Some message";

      Class<?>[] groups() default {};
      Class<? extends Payload>[] payload() default {};
}