private static class MutableValue {
    double value;
    public MutableValue(double value) {
        this.value = value;
    }
    public void add(double value) {
        this.value += value;
    }
}