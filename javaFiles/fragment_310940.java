public class DataValueAdapter implements JsonDeserializer<DataValue> {
  private final static Map<String, Class<?>> FieldToClass;

  static {
    FieldToClass = new HashMap<>();
    FieldToClass.put("PERFORMANCE", PerformanceDataValue.class);
    FieldToClass.put("TIRE_SLIP", TireSlipDataValue.class);
  }

  @Override
  public DataValue deserialize(JsonElement json, Type typeOfT,
                               JsonDeserializationContext context) throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();
    String dataType = jsonObject.get("NAME").getAsString();
    return context.deserialize(json, FieldToClass.get(dataType));
  }
}