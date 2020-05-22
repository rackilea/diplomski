private static enum StructureProperty {

    SIZE, POS_X, POS_Y, POS_Z;

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
};