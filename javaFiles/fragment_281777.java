@JsonTypeInfo(use=Id.NAME, include=As.PROPERTY, property="name")
@JsonSubTypes({ HumiditySensorData.class, ... }) // or register via mapper
public abstract class SensorData { ... }

@JsonTypeName("temperature")
public class TemperaratureSensorData extends SensorData {
   public TemperaratureSensorData(@JsonProperty("data") JsonNode data) {
     // extract pieces out
  }
}