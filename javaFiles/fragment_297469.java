public class ValidateIfAnotherFieldHasValueValidator
implements ConstraintValidator<ValidateIfAnotherFieldHasValue, Object> {

private String fieldName;
private String expectedFieldValue;
private String dependFieldName;

@Override
public void initialize(final ValidateIfAnotherFieldHasValue annotation) {
    fieldName          = annotation.fieldName();
    expectedFieldValue = annotation.fieldValue();
    dependFieldName    = annotation.dependFieldName();
}

@Override
public boolean isValid(final Object value, final ConstraintValidatorContext ctx) {

    if (value == null) {
        return true;
    }

    try {
        final String fieldValue       = BeanUtils.getProperty(value, fieldName);
        final Object dependFieldValue = PropertyUtils.getProperty(value, dependFieldName);

        if (expectedFieldValue.equals(fieldValue)) {

            ctx.disableDefaultConstraintViolation();
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<Object>> errorList = validator.validate(dependFieldValue);

            for(ConstraintViolation<Object> error : errorList) {

                 ctx.buildConstraintViolationWithTemplate(error.getMessageTemplate())
                 .addNode(dependFieldName+"."+error.getPropertyPath())
                 .addConstraintViolation();
            }

            return errorList.isEmpty();
        }

    } catch (final NoSuchMethodException ex) {
        throw new RuntimeException(ex);

    } catch (final InvocationTargetException ex) {
        throw new RuntimeException(ex);

    } catch (final IllegalAccessException ex) {
        throw new RuntimeException(ex);
    }

    return true;
}

}