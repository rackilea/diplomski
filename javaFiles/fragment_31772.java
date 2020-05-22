public void bind(final ObservableValue<? extends T> newObservable) {
    if (newObservable == null) {
        throw new NullPointerException("Cannot bind to null");
    }

    if (!newObservable.equals(this.observable)) {
        unbind();
        observable = newObservable;
        if (listener == null) {
            listener = new Listener(this);
        }
        observable.addListener(listener);
        markInvalid();
    }
}