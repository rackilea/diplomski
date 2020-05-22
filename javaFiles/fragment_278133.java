@Rule
public ExpectedException exception;

@Test
public void test() {
    Analysis analysis = mock(Analysis.class);
    Pipeline pipeline = new Pipeline(analysis);
    pipeline.runAnalyses();
    exception.expect(IllegalStateException.class);
    verify(analysis).finish();
}