public double toDouble(Object number) {
    if (number instanceof Double) {
        return (Double) number;
    } else if (number instanceof Integer) {
        return (Integer) number;
    } else {
        throw new MyRuntimeException("unexpected type: " + number.getClass());
    }
}