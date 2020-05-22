protected void newSliceArray(int n) {
    slices = new Slice[n];
}

protected Slice newSlice(float startAngle) {
    return new Slice(startAngle);
}