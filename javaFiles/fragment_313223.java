package de.scrum_master.app;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface CollationType {
    String value() default "alphabetical";
    String language() default "EN";
}