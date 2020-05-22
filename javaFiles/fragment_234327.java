@SuppressWarnings({"unchecked", "rawtypes"})
public class CaseInsensitiveStringToEnumConverterFactory implements ConverterFactory<String, Enum> {
  @Override
  public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {

    return new CaseInsensitiveStringToEnumConverter(getEnumType(targetType));
  }

  // ConversionUtils are package private. The method is copy-pasted
  private static Class<?> getEnumType(Class<?> targetType) {
    Class<?> enumType = targetType;
    while (enumType != null && !enumType.isEnum()) {
      enumType = enumType.getSuperclass();
    }
    Assert.notNull(enumType, () -> "The target type " + targetType.getName() + " does not refer to an enum");
    return enumType;
  }

  @SuppressWarnings("unchecked")
  private class CaseInsensitiveStringToEnumConverter<T extends Enum> implements Converter<String, T> {
    private final Class<T> enumClass;

    CaseInsensitiveStringToEnumConverter(Class<T> enumClass) {
      this.enumClass = enumClass;
    }

    @Override
    public T convert(String source) {
      if (source.isEmpty()) {
        return null;
      }
      source = source.toUpperCase().trim();
      return (T)Enum.valueOf(enumClass, source);
    }
  }
}