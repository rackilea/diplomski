@Bean
ServletRegistrationBean registerPrometheusExporterServlet(CollectorRegistry metricRegistry) {
    ServletRegistrationBean srb = new ServletRegistrationBean();
    srb.setServlet(new MetricsServlet(metricRegistry));
    srb.setUrlMappings(Arrays.asList("/prometheus"));
    return srb;
}