public class ExistAccountWithUsernameValidator implements ConstraintValidator<ExistAccountWithUsername, String> {

private boolean acceptNull;

@Override
public void initialize(ExistAccountWithUsername constraintAnnotation){
    acceptNull = constraintAnnotation.acceptNull();
}

@Override
public boolean isValid(String value, ConstraintValidatorContext context)
{
    if(value == null)
       return acceptNull;
    return someFurtherCheck(value, context);
}


 }