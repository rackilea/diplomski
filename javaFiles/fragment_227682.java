@Component
@ReadingConverter
public class RedisReadingByteConverter implements Converter<byte[], ObjectId> {

     Jackson2JsonRedisSerializer<ObjectId> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(ObjectId.class);

    @Override
    public ObjectId convert(byte[] source) {
        return jackson2JsonRedisSerializer.deserialize(source);
    }
}