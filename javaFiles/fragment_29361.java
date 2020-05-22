public class PeriodAmountValidator implements ConstraintValidator<ValidPeriodAmount, PeriodAmount> {


    @Override
    public boolean isValid(PeriodAmount periodAmount, ConstraintValidatorContext context) {
        PeriodValidator validator = new PeriodValidator();
        if (!validator.isValid(periodAmount, context)) {
            return false;
        }

        BigDecimal amount = periodAmount.getAmount();
        if (amount == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{invalid.amount.null}").addConstraintViolation();
            return false;
        }
        if (amount.intValue() <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{invalid.amount.value}").addConstraintViolation();
            return false;
        }
        return true;
    }


}