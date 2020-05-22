public final class SampleValidatorFactory extends AbstractGwtValidatorFactory {

  /**
   * Validator marker for the Validation Sample project. Only the classes listed
   * in the {@link GwtValidation} annotation can be validated.
   */
  @GwtValidation(value = Person.class,
      groups = {Default.class, ClientGroup.class})
  public interface GwtValidator extends Validator {
  }

  @Override
  public AbstractGwtValidator createValidator() {
    return GWT.create(GwtValidator.class);
  }
}