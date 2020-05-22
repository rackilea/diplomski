import org.springframework.util.CollectionUtils;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

public abstract class HeaderValidator {

    public boolean validate() {
        Validator validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
        Set<ConstraintViolation<HeaderValidator>> violations = validator.validate(this);
        if (!CollectionUtils.isEmpty(violations)) {
            throw <your exception>
        }
        return true;
    }