public class AfterValidator implements ConstraintValidator<After, LocalDate> {

    private LocalDate date;

    public void initialize(After annotation) {
        date = LocalDate.parse(annotation.value());
    }

    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value != null) {
            if (!value.isAfter(date)) {
                valid = false;
            }
        }
        return valid;
    }
}