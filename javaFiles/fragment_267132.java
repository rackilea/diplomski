...

private final Collector<String> collectorMock = Mockito.mock(Collector.class);
private final Context contextMock = Mockito.mock(Context.class);

private final SampleProcessFunction sampleProcessFunction = new SampleProcessFunction();

@Test
public void testProcessElement_shouldInvokeCollector_whenAnyValuePassed() throws Exception {
    // given
    final String content = "hello ";

    // when
    sampleProcessFunction.processElement(content, contextMock, collectorMock);

    // then
    Mockito.verify(collectorMock).collect(content + "output"); // verifies that collector method was invoked with "hello output" exactly once
}

...