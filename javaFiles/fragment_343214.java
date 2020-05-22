@Rule TestMetrics metrics = new TestMetrics();

@Test
public void invalids() {
  final DoFnTester<InputT, OutputT> doFnTester =
    DoFnTester.of(fixture);
  doFnTester.processElement(input);

  assertThat(metrics,counterValue(fixture.ctr), is(1L));
}