public class ASerializer extends StdSerializer<A> {

  // we'll use this mapper to convert the object into a Map
  private static final ObjectMapper MAPPER = new ObjectMapper();

  // contains the list of property names that belong to parent class only
  private static final Set<String> BASE_PROPERTIES = new HashSet<>(Arrays.asList("primaryKey"));

  public ASerializer() {
    this(A.class);
  }

  public ASerializer(Class<A> t) {
    super(t);
  }

  private void serializeBaseProperties(A value, JsonGenerator jgen) throws IOException {
    // create a Map of base properties and their values to serialize under "base"
    final Map<String, Object> baseProperties = new HashMap<>();
    baseProperties.put("CustomKeyA", value.primaryKey);
    // output the map
    jgen.writeFieldName("base");
    jgen.writeObject(baseProperties);
  }

  @SuppressWarnings("unchecked")
  private void serializeOwnProperties(A value, JsonGenerator jgen) {
    ((Map<String, Object>) MAPPER.convertValue(value, Map.class)) // grab all serializable properties
      .entrySet().stream()
      .filter(entry -> !BASE_PROPERTIES.contains(entry.getKey())) // filter out the ones from base class
      .forEach(property -> writeProperty(property, jgen)); // output own properties to JSON
  }

  @Override
  public void serialize(A value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
    jgen.writeStartObject();
    serializeBaseProperties(value, jgen);
    serializeOwnProperties(value, jgen);
    jgen.writeEndObject();
  }

  private void writeProperty(Map.Entry<String, Object> property, JsonGenerator jgen) {
    try {
      jgen.writeFieldName(property.getKey());
      jgen.writeObject(property.getValue());
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

}