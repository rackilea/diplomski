public final class MyClass {

    private final ReadOnlyIntegerWrapper myInteger = new ReadOnlyIntegerWrapper(2);

    public int getMyInteger() {
        return myInteger.get();
    }

    public ReadOnlyIntegerProperty myIntegerProperty() {
        return myInteger.getReadOnlyProperty();
    }

}