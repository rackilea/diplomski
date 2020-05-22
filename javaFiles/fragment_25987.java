ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
Validator validator = vf.getValidator();
User user = new User();
user.setEmail("user@gmail.com");
Set<ConstraintViolation<User>> constraintViolations = validator
        .validate(user);