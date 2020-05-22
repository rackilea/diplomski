public class OneTimeFormValidator implements org.springframework.validation.Validator {

    @Override
    public boolean supports(Class clazz) {
       return OneTimeForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final OneTimeForm form = (OneTimeForm) target;
        if ("111".equals(form.getA())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "f", "f.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "g", "g.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h", "h.required");
        }
        if ("222".equals(form.getC())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "i", "i.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "j", "j.required");
        }
    }
 }