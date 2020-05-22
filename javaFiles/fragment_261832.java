package de.scrum_master.app;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static de.scrum_master.app.FieldHelper.*;

public class A {
  int number = 11;
  String text = "Hi there!";
  Date date = new Date();
  String optionalText = "I am not really always needed";
  int optionalNumber = 123;

  public void doSomething(List<String> ignoredFields) {
    for (Field field : getFields(this.getClass())) {
      if (!ignoredFields.contains(field.getName())) {
        try {
          System.out.println(field.getName() + " = " + field.get(this));
        } catch (IllegalArgumentException | IllegalAccessException e) {
          throw new RuntimeException("Reflection problem", e);
        }
      }
    }
  }
}