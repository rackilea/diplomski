public class Stock {

    @JsonProperty("Time Series (Daily)")
    private HashMap<String, Day> timeSeries;

    public HashMap<String, Day> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(HashMap<String, Day> timeSeries) {
        this.timeSeries = timeSeries;
    }
}