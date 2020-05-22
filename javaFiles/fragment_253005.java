public final class SynchronizedHandEvaluator {
    private static final SynchronizedHandEvaluator INSTANCE = new SynchronizedHandEvaluator();
    public static final getInstance() {
      return INSTANCE;
    }
    private SynchronizedHandEvaluator() { }

    public synchronized int evaluate(Card[] hand) {
        return ExternalLibrary.evaluate(hand);
    }
}


// then just use the wrapper as you would expect
int result = SynchronizedHandEvaluator.getInstance().evaluate(hand);