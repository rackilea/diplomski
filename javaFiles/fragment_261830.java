package de.scrum_master.app;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class FieldHelper {
  public static Field getField(Class<?> clazz, String fieldName) {
    Field field;
    try {
      field = clazz.getDeclaredField(fieldName);
    } catch (NoSuchFieldException | SecurityException e) {
      throw new RuntimeException("Reflection problem", e);
    }
    field.setAccessible(true);
    return field;
  }

  public static Field[] getFields(Class<?> clazz) {
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields)
      field.setAccessible(true);
    return fields;
  }

  public static List<String> extractIgnoredFieldsList(Class<?> clazz, String fieldName) {
    return Arrays.asList(
      getField(clazz, fieldName)
        .getAnnotation(IgnoreFields.class)
        .fieldNames()
    );
  }
}