List<Map<byte[],byte[]>> list = template.executePipelined(action, new BytesRedisSerializer());

public class BytesRedisSerializer implements RedisSerializer {

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        return (byte[]) t;
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return bytes;
    }

}