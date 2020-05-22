@Override
public boolean isValid(String value, ConstraintValidatorContext context)
{
    if(value == null)
        return true;
    return someFurtherCheck(value, context);
}