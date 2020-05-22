@Component
public class SomeConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        // Verify whether the annotation is present
        return targetType.getAnnotation(RequiresConversion.class) != null;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Long.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        // Conversion logic here
        // In this example it strips "value" from the source string
        String sourceValue = ((String) source).replace("value", "");
        return Long.valueOf(sourceValue);
    }
}