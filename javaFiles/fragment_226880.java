public int size() {
    int returnValue = 0;
    for (V pointer : elements)
        if (pointer != null) {
            returnValue++;
        }
    return returnValue;
}