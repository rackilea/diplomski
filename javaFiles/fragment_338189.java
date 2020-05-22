@JsonSerialize(using = ToStringSerializer.class)
class Cron {
    private String cronString;
    public Cron(String cronString) { // Called by Jackson when deserializing from JSON string
        this.cronString = cronString;
    }
    @Override
    public String toString() { // Called by Jackson when serializing to JSON
        return this.cronString;
    }
}