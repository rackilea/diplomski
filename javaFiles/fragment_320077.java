class SeriesCreator implements Supplier<TimeSeries> {
    public TimeSeries get() {
       return new TimeSeries(new AlphaVantageConnector(APIKEY, TIMEOUT));
    }
}

class YourClass {
   private Supplier<TimeSeries> seriesCreator = new SeriesCreator();