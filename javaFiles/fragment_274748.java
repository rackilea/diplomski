public class MultiKeySerializer implements RedisSerializer<Object>{

private final Charset charset;

public MultiKeySerializer() {
    this(Charset.forName("UTF8"));
}

public MultiKeySerializer(Charset charset) {
    Assert.notNull(charset);
    this.charset = charset;
}

@Override
public byte[] serialize(Object t) throws SerializationException {

    if(t instanceof ArrayList){

        StringBuilder sb = new StringBuilder();
        ArrayList tList = (ArrayList) t;
        for(Object o: tList){
            sb.append(o == null ? null: o.toString()); 
        }

        String string = sb.toString();

        return (string == null ? null : string.getBytes(charset));
    }
    // return null - used to return null. Root cause.
    return t == null ? null : t.toString().getBytes(charset);
}

@Override
public String deserialize(byte[] bytes) throws SerializationException {

    return (bytes == null ? null : new String(bytes, charset));
}
}