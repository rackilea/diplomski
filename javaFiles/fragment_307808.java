public class GenericApplicationValidator implements ApplicationListener<ContextStartedEvent> {

  private ValidatorFactoryBean validatorFactoryBean;

  public void onApplicationEvent(ContextStartedEvent e) {
    // Refer to next step
  }

  public void setValidatorFactoryBean(ValidatorFactoryBean vfb) {
    this.validatorFactoryBean = vfb;
  }
}