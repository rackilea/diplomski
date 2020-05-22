public class ValidatorFactory implements Factory<Validator> {

  private final ConstraintValidatorFactory constraintValidatorFactory;

  @Inject
  public ValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory) {
    this.constraintValidatorFactory = constraintValidatorFactory;
  }

  @Override
  public Validator provide() {
    return Validation.byDefaultProvider().configure().constraintValidatorFactory(
        this.constraintValidatorFactory).buildValidatorFactory()
        .getValidator();
  }

  @Override
  public void dispose(Validator instance) {
    // Nothing
  }
}