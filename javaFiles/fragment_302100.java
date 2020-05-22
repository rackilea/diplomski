public class MessageTypeValidator implements ConstraintValidator<MessageTypeOf, String> {

    private String validValue;

    @Override
    public void initialize(MessageTypeOf constraintAnnotation) {
        this.validValue = constraintAnnotation.value().toString();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return this.validValue.equals(s);
    }
}