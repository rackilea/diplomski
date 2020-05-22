import com.google.auto.service.AutoService;

@AutoService(ConstraintValidator.class)
public class CustomizableTypeValidator implements ConstraintValidator<CustomValidate, CustomValidator> {
    @Override
    public void initialize(final CustomValidate customValidate) {
    }

    @Override
    public boolean isValid(final CustomValidator customValidator, final ConstraintValidatorContext constraintValidatorContext) {
        if ( customValidator == null ) {
            return true;
        }

        return customValidator.isValid(constraintValidatorContext);
    }
}