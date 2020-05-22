public class CustomValidator implements ConstraintValidator<CustomValidation, String> {

    @Override
    public void initialize(CustomValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("Validation called");

        return false;
    }

}