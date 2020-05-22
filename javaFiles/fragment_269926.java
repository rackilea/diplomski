@Override
final boolean forEachWithCancel(Spliterator<P_OUT> spliterator, Sink<P_OUT> sink) {
    boolean cancelled;
    do { } while (
            !(cancelled = sink.cancellationRequested())
            && spliterator.tryAdvance(sink));
    return cancelled;
}