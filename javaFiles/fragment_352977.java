public static class TransformConverter implements Converter<Map<String,List>,Map<String,List>>{

    @Override
    public Map<String,List> convert(Map<String,List> map) {
        return new HashMap<>(map);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructMapType(Map.class, String.class, List.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructMapType(Map.class, String.class, List.class);
    }
}



public static class Transformer {
    @JsonDeserialize(converter = TransformConverter.class)
    Map<String, List<Transform>> transforms;
//rest of your class
}