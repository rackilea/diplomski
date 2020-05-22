import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthdateValidator implements ConstraintValidator<BirthdateConstraint, Person> {

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        int age = value.age;
        String birthdate = value.birthdate;

        // do validation logic here - return true/false     
    }
}