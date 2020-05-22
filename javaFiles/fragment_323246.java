public class ValidQueryRangeValidator implements ConstraintValidator<ValidQueryRange, QueryRange> {

    @Override
    public void initialize(ValidQueryRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(QueryRange queryRange, ConstraintValidatorContext context) {
        if ( queryRange == null ) {
            return true;
        }
        // put your logic here
        if ( queryRange.getGt() == null || queryRange.getLt() == null) {
            return false;
        }

        return true;
    }
}