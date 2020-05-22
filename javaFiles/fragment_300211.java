@Override public void setSpan(Object o, int i, int i1, int i2) {
    if (o instanceof SpanWatcher) {
        o = new UiThreadSpanWatcher((SpanWatcher) o);
    }
    this.builder.setSpan(o, i, i1, i2);
}

public class UiThreadSpanWatcher implements SpanWatcher {
    private final SpanWatcher watcher;

    public UiThreadSpanWatcher(SpanWatcher watcher) {
        this.watcher = watcher;
    }

    @Override public void onSpanAdded(...) {
        Threading.postToUiThread(() -> {
            this.watcher.onSpanAdded(...);
        });
    }
}