public class FormController ... {

    private Map<String, Validator> validators;

    public void validForm(String formName, Properties formProperties) {
        boolean isValid = false;
        Validator validator = validators.get(formName);
        if (validator != null) {
            isValid = validate.isValid(formProperties);
        }
        return isValid;
    }

}