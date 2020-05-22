@check class Test{ int id; @validations...on fields}.

public boolean isValid(Test value, ConstraintValidatorContext context) 
{
// your check logic
context.disableDefaultConstraintViolation();
context.buildConstraintViolationWithTemplate("It should be different for(custom message) .."+ value.id).addConstraintViolation();
return false; // based on constraint filure.

}