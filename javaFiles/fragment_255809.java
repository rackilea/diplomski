public String toString() {

    if (isEmpty()) {
        return String.format("Interval: (EMPTY)");
    } else {
        return String.format("Interval: [%s, %s]", Double.toString(left),
                Double.toString(right));
    }

}