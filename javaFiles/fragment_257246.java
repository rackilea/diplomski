public String toString() {
    if (next != null) {
        return "" + num + " " + next.toString();
    }
    return "" + num;
}