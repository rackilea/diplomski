public static class LoginForm {
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        User user = User.findByEmail(email);
        if (user == null || !Hash.checkPassword(password, user.passwordHash)) {
            errors.add(new ValidationError("", "Invalid email"));
            return errors;
        } else if (!user.validated) {
            errors.add(new ValidationError("", "Not validated email"));
            return errors;
        }
        return null;
    }
}