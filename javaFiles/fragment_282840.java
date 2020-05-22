package de.scrum_master.app;

import java.lang.annotation.Annotation;

public interface ConstraintValidator<T1 extends Annotation, T2> {
  void initialize(T1 annotation);
  boolean isValid(T2 value, ConstraintValidatorContext validatorContext);
}