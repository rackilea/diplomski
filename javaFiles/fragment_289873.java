public void calculateSquares(List<Number> dest, List<? extends Number> src){
    dest.clear();
    for (Number n : src) {
        dest.add(n * n.intValue());
        dest.add(n.doubleValue() * n.doubleValue());
    }
}