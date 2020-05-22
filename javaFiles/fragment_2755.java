private final IntegerProperty roll = new SimpleIntegerProperty();

public int getRoll() {
    return roll.get();
}

public void setRoll(int roll) {
    this.roll.set(roll);
}

public IntegerProperty rollProperty() {
    return this.roll;
}

// same modifications for other int properties
...

private final IntegerBinding total = Bindings.createIntegerBinding(() -> getRoll() + getOtherMod() + getDexMod(), roll, otherMod, dexMod);

public int getTotal() {
    return this.total.get();
}

public IntegerBinding totalProperty() {
    return this.total;
}