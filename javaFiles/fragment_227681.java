@Component
@WritingConverter
public class RedisWritingByteConverter implements Converter<ObjectId, byte[]> {

    Jackson2JsonRedisSerializer<ObjectId> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(ObjectId.class);

    @Override
    public byte[] convert(ObjectId source) {
        return jackson2JsonRedisSerializer.serialize(source);
    }
}