private T currentValue;

...

@Override
protected void fireValueChangedEvent() {
    final T oldValue = currentValue;
    currentValue = observable.getValue();

    ...
    listener.changed(observable, oldValue, currentValue);
    ...
}