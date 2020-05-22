public class CandleStickDataSource {

  private final BinanceApiWebSocketClient client;
  private final Closeable socket;

  private final List<Double> highs = new ArrayList<>();
  private final List<Double> lows = new ArrayList<>();

  private Double lastHigh;    
  private Double lastLow;

  public CandleStickDataSource(String ticker, CandlestickInterval interval) {
    this.client = BinanceApiClientFactory.newInstance().newWebSocketClient();
    this.socket = client.onCandlestickEvent(ticker, interval, new BinanceApiCallback<CandlestickEvent>() {
            @Override
            public void onResponse(CandlestickEvent response) {
                lastHigh = Double.valueOf(response.getHigh());
                lastLow = Double.valueOf(response.getLow()); 
                highs.add(lastHigh);
                lows.add(lastLow);
            }
        });  //  don't forget to call close() on this somewhere when you're done with this class
  }

  public List<Double> getHighs() { return highs; }
  public List<Double> getLows() { return lows; }
  public Double getLastHigh() { return lastHigh; }
  public Double getLastLow() { return lastLow; }

}