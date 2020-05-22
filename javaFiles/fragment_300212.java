private final List<Tuple4<...>> onSpanAddedArguments;

@Override public void onSpanAdded(...) {
    this.onSpanAddedArguments.add(new Tuple4<>(...));
}

public void flush() {
    Threading.postToUiThread(() -> {
        for (Tuple4<...> tuple : this.onSpanAddedArguments) {
            this.watcher.onSpanAdded(tuple.item1, tuple.item2, tuple.item3, tuple.item4);
        }
    });
}