class IntParameter implements Parameter {
    private int value;

    public void parse(String s) {
        value = Integer.parseInt(s);
    }

    public Object getValue() {
        return value;
    }
    ...
}