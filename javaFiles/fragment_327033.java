myObjects.sort(Comparator.comparingInt(s -> {
    int ind  = myOtherObjects.indexOf(s);
    if (ind >= 0) {
        return ind;
    }
    return Integer.MAX_VALUE;
}));