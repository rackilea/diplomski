if (userInfo.getAge() > 20) {
  Passport passport = userInfo.passportId()
                       .map(this::findPassport)
                       .orElseThrow(() -> new IllegalArgumentException("Set passport"));
  ...                            
}