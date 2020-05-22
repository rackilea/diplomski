public class InjectingValidationFeature implements Feature {

  @Override
  public boolean configure(FeatureContext context) {
    context.register(new AbstractBinder() {
      @Override
      protected void configure() {
        bindFactory(ValidatorFactory.class).to(Validator.class).in(Singleton.class);
        bind(InjectingConfiguredValidator.class).to(ConfiguredValidator.class).in(Singleton.class);
        bind(InjectingConstraintValidatorFactory.class).to(ConstraintValidatorFactory.class).in(Singleton.class);
      }
    });

    return true;
  }
}