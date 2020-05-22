import org.dozer.CustomConverter;

public class LongToStringConverter implements CustomConverter {
    @Override
    public Object convert(Object existingDestFieldValue, Object srcFieldValue,
                          Class<?> destinationClass, Class<?> sourceClass) {
        if (srcFieldValue != null && srcFieldValue instanceof Long
                && String.class.equals(destinationClass)) {
            return String.format("%04d", (Long)srcFieldValue);
        }

        return null;
    }
}