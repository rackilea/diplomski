public AbstractParametersObject deserialize(JsonParser p, DeserializationContext ctxt) 
    throws IOException {

    Class<? extends AbstractParametersObject> targetClass = null;
    ObjectMapper mapper = (ObjectMapper) p.getCodec();
    ObjectNode root =mapper.readTree(p);
    boolean isReference = root.has("$ref");
    boolean isParameter = root.has("in");

    if (isReference) targetClass = ParameterAsReference.class;
    } else if (isParameter) {
        targetClass = Optional.of(root.get("in")).map(JsonNode::asText).map(value -> {
            Class<? extends AbstractParametersObject> effectiveClass = null;

            switch (value) {
                case "body": effectiveClass = BodyParameterObject.class;
                    break;
                case "query": effectiveClass = QueryParameterObject.class;
                    break;
                case "path": effectiveClass = PathParameterObject.class;
                    break;
                case "formData": effectiveClass = FormDataParameterObject.class;
                    break;
                case "header": effectiveClass = HeaderParameterObject.class;
                    break;
            }

            return effectiveClass;
        }).orElseThrow(() -> new IllegalArgumentException("todo"));
    }

    return mapper.treeToValue(root, targetClass);
}