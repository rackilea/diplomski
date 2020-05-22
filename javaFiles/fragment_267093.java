$ javap JacksonGenericSerializer.class

Compiled from "JacksonGenericSerializer.scala"
public class JacksonGenericSerializer<T> implements java.io.Closeable, java.lang.AutoCloseable, org.apache.kafka.common.serialization.Serializer<T>, org.apache.kafka.common.serialization.Deserializer<T> {
  public void configure(java.util.Map<java.lang.String, ?>, boolean);
  public byte[] serialize(java.lang.String, T);
  public T deserialize(java.lang.String, byte[]);
  public void close();
  public JacksonGenericSerializer(scala.reflect.Manifest<T>);
}