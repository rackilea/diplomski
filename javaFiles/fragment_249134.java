public void forEachRemaining(Consumer<? super E> action) {
    Objects.requireNonNull(action);
    if (hasNext) {
        action.accept(e);
        hasNext = false;
    }
}