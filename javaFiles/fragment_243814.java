package myvalidators;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.*;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AllUpperCaseValidator.class)
@play.data.Form.Display(name="constraint.alluppercase")
public @interface AllUpperCase {
    String message() default AllUpperCaseValidator.message;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}