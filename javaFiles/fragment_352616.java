class TimestampThing {
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    DateTime timestamp

    @JsonCreator
    public TimestampThing(@JsonProperty('timestamp') DateTime timestamp) {
        this.timestamp = timestamp
    }
}