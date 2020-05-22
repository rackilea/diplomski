package de.scrum_master.app;

public class MyValidator implements ConstraintValidator<MyAnnotation, String> {
  @Override
  public void initialize(MyAnnotation annotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext validatorContext) {
    if ("msg".equals(value))
      return true;
    return false;
  }
}