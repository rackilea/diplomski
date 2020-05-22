import java.lang.reflect.Array;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullOrNotEmptyValidator implements ConstraintValidator<NullOrNotEmpty, Object> {

    @Override
    public void initialize(NullOrNotEmpty constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {

        if (object == null) {
            return true;
        }

        final Class<?> fieldClass = object.getClass();
        if (fieldClass.isArray()) {
            return Array.getLength(object) > 0;
        }

        if (Iterable.class.isAssignableFrom(fieldClass)) {
            return ((Iterable) object).iterator().hasNext();
        }

        if (Map.class.isAssignableFrom(fieldClass)) {
            return !((Map) object).isEmpty();
        }

        return false;
    }

}