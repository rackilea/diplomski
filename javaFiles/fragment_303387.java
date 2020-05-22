@Override
public boolean isValid(String value, ConstraintValidatorContext context) {

    if (value == null) {
        return true;
    }

    if (!m_boundedTo.contains(value)) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                value + " should be one of " + m_boundedTo)
                .addConstraintViolation();
        return false;
    }
    return true;
}