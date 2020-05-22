static class HandleEv extends DoFn<String, String> {
  private final TupleTag<String> failedData;
  public HandleEv(TupleTag<String> failedData) {
    this.failedData = failedData;
  }

  @ProcessElement
  public void processElement(ProcessContext c) throws Exception {
    c.output("test")
    c.output(failedData,"failed")
  }
}