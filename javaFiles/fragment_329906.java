public long calculateTotal(List<Long> values) {
    long runningTotal = 0;
    for (Long value: values) {
        runningTotal += value;
    return runningTotal;
}