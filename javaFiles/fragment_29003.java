public class MyValidator implements ConstraintValidator<MyValidationAnnotation, String> {
public void initialize(MyValidationAnnotation constraintAnnotation) {
}

public boolean isValid(String id, ConstraintValidatorContext context) {
    //write your logic here..
    return true;
}