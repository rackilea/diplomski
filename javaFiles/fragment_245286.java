public int compareTo(Object o) {
    int otherNumber = ((Integer) o).intValue();
    int thisNumber = this.intValue();
    if (otherNumber > thisNumber) {
        return 1;
    } else if (otherNumber < thisNumber) {
        return -1;
    } else {
        return 0;
    }
}