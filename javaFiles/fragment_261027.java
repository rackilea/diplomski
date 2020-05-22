public void validateEntity(final Object object, final Class<? extends Default>... classes)
        throws IllegalArgumentException {
    final Set<ConstraintViolation<Object>> errors = validator.validate(object, classes);
    if (!errors.isEmpty()) {
        throw new IllegalArgumentException(returnErrors(errors));
    }
}


public String returnErrors(final Set<ConstraintViolation<Object>> errors) {
    final StringBuilder builder = new StringBuilder();
    for (final ConstraintViolation<Object> error : errors) {
        builder.append(error.getMessage());
    }
    return builder.toString();
}