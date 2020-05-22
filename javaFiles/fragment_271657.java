public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.statisticsscreen);        
  tv = (TextView) findViewById(R.id.xmltextview);      
  loadFeed();

  private void loadFeed() {
    try {
      BaseFeedParser parser = new BaseFeedParser();
      messages = parser.parse();
      StringBuilder builder = new StringBuilder();
      for (Message msg : messages){
        builder.append(msg.getTemperature());
        builder.append(",");
        builder.append(msg.getRain());
        builder.append(",");
        builder.append(msg.getWind());
        builder.append("\n");
      }
      tv.setText(builder.toString());
    } catch (Throwable t){
      Log.e("AndroidNews",t.getMessage(),t);
    }
  }
}