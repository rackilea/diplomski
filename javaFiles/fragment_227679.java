@Component
@ReadingConverter
@Slf4j
public class RedisReadingStringConverter implements Converter<String, ObjectId> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ObjectId convert(String source) {
        try {
            return objectMapper.readValue(source, ObjectId.class);
        } catch (IOException e) {
            log.warn("Error while converting to ObjectId.", e);
            throw new IllegalArgumentException("Can not convert to ObjectId");
        }
    }
}