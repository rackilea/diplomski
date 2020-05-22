@Target({ ElementType.TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
@Documented
/**
 * Annotation to allow custom validation against model classes
 */
public @interface Validate {

  /**
   * Validation message
   */
  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * Validation method name
   */
  String method() default "";
}


public class CustomValidator implements ConstraintValidator<Validate, BusinessObject> {

  private static Log log = LogFactory.getLog(CustomValidator.class);
  private String validator;


  @Override
  public void initialize(Validate constraintAnnotation) {
    validator = constraintAnnotation.method();
  }

  @Override
  public boolean isValid(BusinessObject bo, ConstraintValidatorContext constraintContext) {
    try {
      return isValidForMethod(bo);
    } catch (Exception e) {
      /* Error durante la ejecución de la condición o del validador */
      log.error("Error validating "+bo, e);
      return false;
    }
  }


  private boolean isValidForMethod(BusinessObject bo) throws Exception {
    Method validatorMethod =  ReflectionUtils.findMethod(bo.getClass(), validator, new Class[] {});
    if (validatorMethod != null) {
      /* Validator call */
      Boolean valid = (Boolean) validatorMethod.invoke(bo);
      return valid != null && valid;
    } else {
      /* Method not found */
      log.error("Validator method not found.");
      return false;
    }
  }

}