private String phone;

  public String getPhone() {
    return phone;
  }

  @RequiredStringValidator(type= ValidatorType.FIELD, message="Phone required.")
  @RegexFieldValidator(type= ValidatorType.FIELD, message="Invalid Phone",
    regexExpression="\\([0-9][0-9][0-9]\\)\\s[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
  public void setPhone(String phone) {
    this.phone = phone;
  }