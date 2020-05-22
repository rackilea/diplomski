// private int percent;
private final ReadOnlyIntegerWrapper percent = new ReadOnlyIntegerWrapper();

public ReadOnlyIntegerProperty percentProperty() {
    return percent.getReadOnlyProperty();
}

public int getPercent() {
    return percent.get();
}

...
// percent = i
percent.set(i); // replace assinment to int field with setting the property