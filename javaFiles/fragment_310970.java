static interface Mixin {

    @JsonSerialize(using = ByteBufferSerializer.class, contentAs = String.class)
    ByteBuffer getData();

    @JsonDeserialize(using = ByteBufferDeserializer.class, contentAs = String.class)
    void setData(ByteBuffer data);

}