public String toString() {

    String result;

    if (isEmpty()) {
        result = String.format("Interval: (EMPTY)");
    } else {
        result = String.format("Interval: [%s, %s]", Double.toString(left),
                Double.toString(right));
    }
    return result;
}