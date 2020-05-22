public interface Serializer<T> {

    byte[] write(T objectToSerialize);

    //to build a factory/service around it
    boolean canDeserialize(byte[] serializedObject);

    T read(byte[] serializedObject);
}