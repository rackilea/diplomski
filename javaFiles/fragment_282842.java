package de.scrum_master.app;

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = { MyValidator.class })
public @interface MyAnnotation {
  String message() default "DEFAULT_FALSE";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}