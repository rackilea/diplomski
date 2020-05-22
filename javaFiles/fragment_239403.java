public class UrlValidatorImplementation implements ConstraintValidator<UrlValidator, String> {
    @Override
    public void initialize(UrlValidator annotation) {
        // initialization, probably not needed
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        // implementation of the url validation
    }
}