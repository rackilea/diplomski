public int compareTo(Date date) {
    if (milliseconds < date.milliseconds) {
        return -1;
    }
    if (milliseconds == date.milliseconds) {
        return 0;
    }
    return 1;
}