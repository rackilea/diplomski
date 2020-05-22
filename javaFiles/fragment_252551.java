public class Time {
    @JsonProperty(value="start_time")
    private String startTime;
    @JsonProperty(value="end_time")
    private String endTime;

    // Getter Setter
}

ObjectMapper mapper = new ObjectMapper();
Map<String, Map<String, Time>> data = mapper.readValue(json, new TypeReference<Map<String, Map<String, Time>>>() {});