static final MetricRegistry metrics = new MetricRegistry();
static final Timer timer = metrics.timer("MyTimer");

static void startReport() {
    ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    reporter.start(1, TimeUnit.MINUTES);
}

@BeforeClass
public static void init() {
    startReport();
}