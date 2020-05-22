private static void addSampleData(Holding h) {
    if (holdingCount < holding.length) {
        holding[holdingCount++] = h;
    } else {
        throw new IllegalStateException("Tried to add too many holdings to array");
    }
}