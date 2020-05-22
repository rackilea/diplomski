import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BirthdateValidator.class)
public @interface BirthdateConstraint {
    String message() default "Custom error message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}