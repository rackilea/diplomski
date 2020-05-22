class MyModel{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyModel)) return false;
        MyModel myModel = (MyModel) o;
        return value == myModel.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}