public class EmailValidCheck extends ABaseController implements
        ConstraintValidator<EmailValid, Map<String,String>> {
    @Override
    public void initialize(EmailValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(Map<String,String> mapOfEmail,
            ConstraintValidatorContext cvc) {
            //Implement Email Validation Login Here.
    }       
}