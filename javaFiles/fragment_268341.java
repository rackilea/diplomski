class MyClass {

    ...

    @DynamoDBMarshalling(marshallerClass = LocalDateTimeConverter.class)
    public LocalDateTime getStartTime() {
        return startTime;
    }

    ...
    static public class LocalDateTimeConverter implements DynamoDBMarshaller<LocalDateTime> {

        @Override
        public String marshall(LocalDateTime time) {
            return time.toString();
        }

        @Override
        public LocalDateTime unmarshall(Class<LocalDateTime> dimensionType, String stringValue) {
            return LocalDateTime.parse(stringValue);
        }
    }
}