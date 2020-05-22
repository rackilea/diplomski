@Component
@WritingConverter
@Slf4j
public class RedisWritingStringConverter implements Converter<ObjectId, String> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convert(ObjectId source) {
        try {
            return objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            log.warn("Error while converting ObjectId to String.", e);
            throw new IllegalArgumentException("Can not convert ObjectId to String");
        }
    }
}