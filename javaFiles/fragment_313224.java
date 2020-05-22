package de.scrum_master.app;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface AnnotateGetter {
    Class<? extends Annotation>[] value();
}