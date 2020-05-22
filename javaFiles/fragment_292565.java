public class MethodAndInstrumentsValidator 
             implements ConstraintValidator<ValidMethodAndInstruments, Buyer> {
    public final void initialize(final ValidMethodAndInstruments annotation) {
        // setup
    }

    public final boolean isValid(final Buyer value, 
                                 final ConstraintValidatorContext context) {
        // validation logic
        if(!"foo".equals(value.getMethod())) {
            // do whatever conditional validation you want
        }
    }

}