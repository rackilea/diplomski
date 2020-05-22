@Override
public boolean isValid(List<String> value,
        ConstraintValidatorContext context) {
    if (value == null) {
        return true;
    }

    boolean allValid = true;
    CoBoundedStringConstraints constraints = new CoBoundedStringConstraints();
    constraints.initialize(m_annotation);
    for (String string : value) {
        if (!constraints.isValid(string, context)) {
            allValid = false;
        }
    }
    return allValid;
}