import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public final class CustomFieldNamingStrategy
  extends PropertyNamingStrategy
{
  private static final long serialVersionUID = 8263960285216239177L;
  private final Map<String, String> fieldRemapping;
  private final Map<String, String> reverseRemapping;

  public CustomFieldNamingStrategy(Map<String, String> newFieldRemappings)
  {
    fieldRemapping = newFieldRemappings;
    reverseRemapping = fieldRemapping.entrySet()//
                                     .stream()//
                                     .collect(Collectors.toMap(Map.Entry::getValue,
                                                               Map.Entry::getKey));
  }

  @Override
  public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName)
  {
    if (field.getDeclaringClass().getName().equals(JiraFields.class.getName()))
    {
      return reverseRemapping.getOrDefault(defaultName, defaultName);
    }
    return defaultName;
  }

  @Override
  public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method,
                                    String defaultName)
  {
    if (method.getDeclaringClass().getName().equals(JiraFields.class.getName()))
    {
      return reverseRemapping.getOrDefault(defaultName, defaultName);
    }
    return defaultName;
  }

  @Override
  public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method,
                                    String defaultName)
  {
    if (method.getDeclaringClass().getName().equals(JiraFields.class.getName()))
    {
      return reverseRemapping.getOrDefault(defaultName, defaultName);
    }
    return defaultName;
  }
}