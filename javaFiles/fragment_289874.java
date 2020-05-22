public void calculateSquares(List<? super Double> dest, List<? extends Number> src){
    dest.clear();
    for (Number n : src) {
        dest.add((double)n * n.intValue());
        dest.add(n.doubleValue() * n.doubleValue());
    }
}