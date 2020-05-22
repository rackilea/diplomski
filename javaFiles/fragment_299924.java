public class ValidJsonValidator implements ConstraintValidator<ValidJsonConstraint, String> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void initialize(ValidJsonConstraint constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    try {
      objectMapper.readTree(value);
      return true;
    } catch (JsonProcessingException e) {
      return false;
    }
  }
}