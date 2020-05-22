@Slf4j
public class AbstractEventDeserializer<T extends AbstractEvent> implements ExtendedDeserializer<T> {

    private Map<String, Class<T>> mappers = new HashMap<>();

    // default behavior
    @Override
    public T deserialize(String arg0, byte[] devBytes) {
        ObjectMapper mapper = new ObjectMapper();
        T bar = null;
        try {
            bar = (T) mapper.readValue(devBytes, Bar.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bar;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        log.info("handling...");
        headers.forEach(header -> log.info("   {}: {}", header.key(), getHeaderValueAsString(header)));
        Optional<String> classTypeFromHeader = getClassTypeFromHeader(headers);
        if (classTypeFromHeader.isPresent()) {
            return parseFromJson(data, mappers.get(classTypeFromHeader.get()));
        }
        return deserialize(topic, data);
    }

    private Optional<String> getClassTypeFromHeader(Headers headers) {
        return StreamSupport.stream(headers.headers("X-CLASS-TYPE").spliterator(), false)
                .map(Header::value)
                .map(String::new)
                .findFirst();
    }

    private String getHeaderValueAsString(Header header) {
        return Optional.ofNullable(header.value())
                .map(String::new)
                .orElse(null);
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        log.info("configuring deserialiser");
        if (arg0.containsKey("mappers")) {
            this.mappers = (Map<String, Class<T>>) arg0.get("mappers");
        }
        arg0.keySet().forEach(key -> log.info("   {}:{}", key, arg0.get(key)));
    }

}