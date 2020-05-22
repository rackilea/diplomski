public class Registration {
  @Size(max = 80)
  @Column(name=”PARTNER_ROLE” length=”80”)
  private String partnerRole;

  // you need to get this from somewhere, but this depends on your environment
  private ValidatorFactory validatorFactory;

  public Set<ConstraintViolation<Registration>> validate() {
    Validator validator = validatorFactory.getValidator();
    return validator.<Registration>validate(this);
  }
}