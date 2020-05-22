@Override
public void validate(Object target, Errors errors) {
    User user=(User)target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotNull.user.name", "Name cannot be blank.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotNull.user.address", "Address cannot be blank.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotNull.user.email", "email cannot be blank.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotNull.user.password", "password cannot be blank.");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "about", "NotNull.user.about", "About cannot be blank.");

}