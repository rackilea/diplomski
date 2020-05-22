public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    public void validate(Object command, Errors errors) {
        User user = (User) command;

        if(user.getOccupation() == null)
            errors.rejectValue("occupation", "errors.required", null);

        if(user.getCountry() == null)
            errors.rejectValue("country", "errors.required", null);
    }

}