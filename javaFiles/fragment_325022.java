public class InjectingConstraintValidatorFactory implements ConstraintValidatorFactory {

  private final ServiceLocator serviceLocator;

  @Inject
  public InjectingConstraintValidatorFactory(ServiceLocator serviceLocator) {
    this.serviceLocator = serviceLocator;
  }

  @Override
  public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
    return this.serviceLocator.createAndInitialize(key);
  }

  @Override
  public void releaseInstance(ConstraintValidator<?, ?> instance) {
    this.serviceLocator.preDestroy(instance);
  }
}