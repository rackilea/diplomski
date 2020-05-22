Platform.runLater(new Runnable() {
   @Override
   public void run() {
      BarChartSample chart = new BarChartSample();
      fxPanel.setScene(new Scene(chart));
   }
});