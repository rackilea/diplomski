<T> void setupAnswer (/* whatever args */) {
  doAnswer(invocation -> ((Supplier<T>) invocation.getArgument(2)).get())
      .when(mockLogsBasedMetricService)
      .recordElapsedTime(
          any(MeasurementBundle.Builder.class),
          any(DistributionMetric.class),
          ArgumentMatchers.<Supplier<T>>any());
}