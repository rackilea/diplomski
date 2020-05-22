public class InjectingConfiguredValidator extends DropwizardConfiguredValidator {
  @Inject
  public InjectingConfiguredValidator(Validator validator) {
    super(validator);
  }
}