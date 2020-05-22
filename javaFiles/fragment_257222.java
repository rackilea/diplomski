public class EitherOrValidator implements ConstraintValidator<EitherOr, City>{

    @Override
    public void initialize(EitherOr arg0) { }

    @Override
    public boolean isValid(City city, ConstraintValidatorContext ctx) {
        return (city.getProvince() == null && city.getCountry() != null) 
                || (city.getProvince() != null && city.getCountry() == null);
    }


}