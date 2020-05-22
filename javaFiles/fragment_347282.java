class CGCValidator implements ConstraintValidator<CGC, String> {

    boolean canBeNull;

    @Override
    public void initialize(CGC constraintAnnotation) {
        canBeNull = constraintAnnotation.canBeNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return canBeNull || value != null;
    }
}