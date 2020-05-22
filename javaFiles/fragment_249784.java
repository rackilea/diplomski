@Getter
@Setter
public class Data {

    @JsonProperty("is_charging;")
    public boolean isCharging;

}

public static void main(String... args) throws JsonProcessingException, IOException {

    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
    objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, false);
    objectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, false);

    Data data = objectMapper.readValue("{\"is_charging\": true}", Data.class);

    System.out.print(objectMapper.writeValueAsString(data));
}