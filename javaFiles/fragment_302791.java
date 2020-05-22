public static double metricValue = 123;

@GET
@Path("/metrics")
public String getMetrics() {
    Writer writer = new StringWriter();
    CollectorRegistry registry = new CollectorRegistry();
    Gauge gauge = Gauge.build().name("logged_in_users").help("Logged in users").register(registry);
    gauge.set(metricValue);
    TextFormat.write004(writer, registry.metricFamilySamples());
    return writer.toString();
}