private static final class Function extends DoFn<KV<Key, String>, Void> implements Serializable {
  private static final long serialVersionUID = 2417984990958377700L;

  private static final int LIMIT = 500;

  @StateId("bufferedSize")
  private final StateSpec<Object, ValueState<Integer>> bufferedSizeSpec =
      StateSpecs.value(VarIntCoder.of());

  @StateId("buffered")
  private final StateSpec<Object, BagState<String>> bufferedSpec =
      StateSpecs.bag(StringUtf8Coder.of());

  @TimerId("expiry")
  private final TimerSpec expirySpec = TimerSpecs.timer(TimeDomain.EVENT_TIME);

  @ProcessElement
  public void processElement(
      ProcessContext context,
      BoundedWindow window,
      @StateId("bufferedSize") ValueState<Integer> bufferedSizeState,
      @StateId("buffered") BagState<String> bufferedState,
      @TimerId("expiry") Timer expiryTimer) {

    int size = firstNonNull(bufferedSizeState.read(), 0);
    bufferedState.add(context.element().getValue());
    size += 1;
    bufferedSizeState.write(size);
    expiryTimer.set(window.maxTimestamp().plus(allowedLateness));

    if (size > LIMIT) {
      flush(context, bufferedState, bufferedSizeState);
    }
  }

  @OnTimer("expiry")
  public void onExpiry(
      OnTimerContext context,
      @StateId("bufferedSize") ValueState<Integer> bufferedSizeState,
      @StateId("buffered") BagState<String> bufferedState) {
    flush(context, bufferedState, bufferedSizeState);
  }

  private void flush(
      WindowedContext context,
      BagState<String> bufferedState,
      ValueState<Integer> bufferedSizeState) {
    Iterable<String> buffered = bufferedState.read();

    // build batch request from buffered
    ...

    // clear things
    bufferedState.clear();
    bufferedSizeState.clear();
  }
}