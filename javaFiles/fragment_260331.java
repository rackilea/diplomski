public class ValidationForm {

    /**
     * Field allows only if correctly formatted
     */
    public static Validator<String> formatValidate = (Control control, String value) -> {
        boolean condition = value != null
                ? !value.matches("^\\({1}+[0-9]+\\,[0-9]+\\,[0-9]+\\){1}+\\+{1}"
                        + "+[a-z]{1}+\\({1}+[0-9]+\\,[0-9]+\\,[0-9]+\\){1}+\\+{1}"
                        + "+[a-z]{1}+\\({1}+[0-9]+\\,[0-9]+\\,[0-9]+\\){1}$") : value == null;

        return ValidationResult.fromMessageIf(control, "Not a valid input \n"
                + "Should be formatted \" (x,y,z) + q(a,b,c) + p(a,b,c) \"",
               Severity.ERROR, condition);
    };
   ...