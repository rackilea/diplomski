public class Data {
    @JsonProperty("is_charging")
    public boolean isCharging; 
}

objectMapper.writeValueAsString(new Data());