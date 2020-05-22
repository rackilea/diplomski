public void validate(Object target, Errors errors) {
    validator.validate(target, errors);

    String password = null;
    String confirm = null;
    if (target instanceof Registration) {
        Registration registration = (Registration) target;
        password = registration.getPassword();
        confirm = registration.getConfirm_password();
    } else if (target instanceof Another) {
        Another another = (Another) target;
        password = another.getPassword();
        confirm = another.getConfirm_password();
    }
    if (! confirm.equals(password())) {
        errors.rejectValue("confirm_password", "confirm_password.confirm");
    }

}