public static class Info {
  @JsonProperty("Product")
  public String product;
  // Empty in the 0d version, One entry in the 1d version, two entries in the 2d version.
  @JsonProperty("Dimensions")
  public String[] dimensions;

}

public static class Info0d extends Info {
}

public static class Info1d extends Info {
  @JsonProperty("Labels")
  public String[] labels;
}

public static class Info2d extends Info {
  @JsonProperty("Labels")
  public String[][] labels;
}

public static class InfoDeserializer extends StdDeserializer<Info> {
  public InfoDeserializer() {
    super(Info.class);
  }

  @Override
  public Info deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    Class<? extends Info> variantInfoClass = null;
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    ObjectNode root = (ObjectNode) mapper.readTree(jp);
    // Inspect the `diemnsions` field to decide what to expect.
    JsonNode dimensions = root.get("Dimensions");
    if ( dimensions == null ) {
      variantInfoClass = Info0d.class;
    } else {
      switch ( dimensions.size() ) {
        case 1:
          variantInfoClass = Info1d.class;
          break;

        case 2:
          variantInfoClass = Info2d.class;
          break;
      }
    }
    if (variantInfoClass == null) {
      return null;
    }
    return mapper.readValue(root, variantInfoClass);
  }
}