public class TemperatureRegister {

    @JsonProperty("hardwareId")
    private int m_hardwareId;

    @JsonProperty("sensorId")
    private int m_sensorId;

    @JsonProperty("registerTime")
    private OffsetDateTime m_registerTime;

    @JsonProperty("temperature")
    private double m_temperature;

    // Constructor, getters and setters omitted
}