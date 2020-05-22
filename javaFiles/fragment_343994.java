class ClusterTypeKeySerializer extends StdSerializer<ClusterType> {

    protected ClusterTypeKeySerializer() {
        super(ClusterType.class);
    }

    @Override
    public void serialize(ClusterType value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonGenerationException {
        jgen.writeFieldName(value.getValue());
    }

}