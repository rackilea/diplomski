class ComplexObject {
    private IntegerProperty value1 = new SimpleIntegerProperty();
    private IntegerProperty value2 = new SimpleIntegerProperty();
    private BooleanProperty internalChanged = new SimpleBooleanProperty(false);

    public ComplexObject() {
        this.internalChanged.bind(Bindings.createBooleanBinding(() ->
            this.internalChanged.set(!this.internalChanged.get()), this.value1, this.value2));
    }

    public IntegerProperty value1Property() { return this.value1; }
    public int getValue1() { return this.value1.get(); }
    public void setValue1(int value) { return this.value1.set(value); }

    public IntegerProperty value2Property() { return this.value2; }
    public int getValue2() { return this.value2.get(); }
    public void setValue2(int value) { return this.value2.set(value); }

    public void setNewValue1(int newValue) { /* What value is this??? */ }

    public BooleanProperty internalChangedProperty() { return this.internalChanged; }
}

class ComplexRenderer extends Canvas implements InvalidationListener {
    private ComplexObject complexObject;

    public void setComplexObject(ComplexObject complexObject) {
        this.complexObject = complexObject;
        complexObject.internalChangedProperty().addListener(this);
    }
    @Override public void invalidated(Observable observable) {
        // Something inside complex object changed
    }

    public void draw() { ... }
}