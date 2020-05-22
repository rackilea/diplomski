@Bean
MeterBinder compositeBinder() {
    return (registry) -> {
        // register Meters via a binder
        new FooBinder().bindTo(registry);
        new BarBinder().bindTo(registry);
        // register without indirection
        registry.gauge("mygauge", BigDecimal.TEN);
    };
}