StatsdConfig config = new StatsdConfig() {
    @Override
    public String get(String k) {
        return null;
    }


    @Override
    public StatsdFlavor flavor() {
        return StatsdFlavor.Etsy;
    }
};

MeterRegistry registry = new StatsdMeterRegistry(config, Clock.SYSTEM);

Vertx vertx = Vertx.vertx(new VertxOptions()
  .setMetricsOptions(new MicrometerMetricsOptions()
    .setMicrometerRegistry(registry)
    .setEnabled(true)));