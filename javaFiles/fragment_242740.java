public class AddressValidator implements ConstraintValidator<Address, DemoBean> {

    public void initialize(Address constraintAnnotation) {
      // initialize the zipcode/city/country correlation service
    }

    @Override
    public boolean isValid(DemoBean addressBean, ConstraintValidatorContext constraintValidatorContext) {
        return true; 
    }
}