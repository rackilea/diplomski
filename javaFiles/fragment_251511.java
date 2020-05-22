public class CarPolicyIdAttributeConverter implements GenericConverter {

        @Override
        public Set<ConvertiblePair> getConvertibleTypes() {
            final ConvertiblePair[] pairs = new ConvertiblePair[] {
                new ConvertiblePair(String.class, String.class)
            };
            return ImmutableSet.copyOf(pairs);
        }

        @Override
        public Object convert(final Object source, final TypeDescriptor sourceType, final TypeDescriptor targetType) {
            if (targetType.getAnnotation(Uppercase.class) != null) {
                return ((String)source).toUppercase();
            }
            return source;
        }
    }