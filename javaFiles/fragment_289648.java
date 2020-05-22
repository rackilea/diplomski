public class InvoiceAddressValidator implements ConstraintValidator<InvoiceAddressChecker, Addresses> {

    @Override
    public void initialize(InvoiceAddressChecker params) {
    }

    @Override
    public boolean isValid(Addresses invoiceAddress, ConstraintValidatorContext context) {
        // invoice address is optional
        if (invoiceAddress == null) {
            return true;
        }
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Addresses>> constraintViolations;
        constraintViolations = validator.validate(invoiceAddress, Default.class, InvoiceAddressCheck.class);
        if (constraintViolations.isEmpty()) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            Iterator<ConstraintViolation<Addresses>> iter = constraintViolations.iterator();
            while (iter.hasNext()) {
                ConstraintViolation<Addresses> violation = iter.next();
                context.buildConstraintViolationWithTemplate(violation.getMessage()).addNode(
                        violation.getPropertyPath().toString()).addConstraintViolation();
            }
            return false;
        }
    }
}