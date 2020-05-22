public class DocumentTypeValidator implements ConstraintValidator<ValidDocumentType, String> {

    private String[] extenstions;

    public void initialize(ValidDocumentType constraintAnnotation) {
        this.extenstions = constraintAnnotation.value();
    }

    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {

        if (object == null)
            return true;

        for(String ext:extenstions) {
            if(object.toLowerCase().matches(ext.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}