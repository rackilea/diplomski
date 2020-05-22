class AImpl implements A {
    boolean someCase;

    public AImpl(boolean value) {
        this.someCase = value;
    }

    @Override
    public boolean isSomeCase() {
        return someCase;
    }
}