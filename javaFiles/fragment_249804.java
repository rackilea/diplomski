class InnerSetDeserializer extends JsonDeserializer<Set> implements ContextualDeserializer {

  private final JavaType propertyType;

  public InnerSetDeserializer() {
    this(null);
  }

  public InnerSetDeserializer(JavaType propertyType) {
    this.propertyType = propertyType;
  }

  @Override
  public Set deserialize(JsonParser p, DeserializationContext context) throws IOException {
    p.nextToken(); // SKIP START_OBJECT
    p.nextToken(); // SKIP any FIELD_NAME

    CollectionType collectionType = getCollectionType(context);
    List<Map<String, Object>> list = context.readValue(p, collectionType);

    p.nextToken(); // SKIP END_OBJECT

    return list.stream().map(Map::values).flatMap(Collection::stream).collect(Collectors.toSet());
  }

  private CollectionType getCollectionType(DeserializationContext context) {
    TypeFactory typeFactory = context.getTypeFactory();
    MapType mapType =
        typeFactory.constructMapType(
            Map.class, String.class, propertyType.getContentType().getRawClass());

    return typeFactory.constructCollectionType(List.class, mapType);
  }

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
    return new InnerSetDeserializer(property.getType());
  }
}