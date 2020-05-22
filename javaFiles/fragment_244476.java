@Autowired private Validator validator;

 public Flux<UserContactsModel> getUserContacts(@RequestBody Mono<@Valid LoginModel> loginDetail) {

    return loginDetail
        .filter(this::validate)
        .map(....);
}

 private boolean validate(LoginModel loginModel) {

    Set<ConstraintViolation<LoginModel>> constraintViolations = validator.validate(loginModel);

    if (CollectionUtils.isNotEmpty(constraintViolations)) {
      StringJoiner stringJoiner = new StringJoiner(" ");
      constraintViolations.forEach(
          loginModelConstraintViolation ->
              stringJoiner
                  .add(loginModelConstraintViolation.getPropertyPath().toString())
                  .add(":")
                  .add(loginModelConstraintViolation.getMessage()));
      throw new RuntimeException(stringJoiner.toString());
    }

    return true;
  }