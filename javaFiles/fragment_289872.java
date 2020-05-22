public void <T extends Number> calculateSquares(List<Number> dest, List<T> src){
    dest.clear();
    for (T n : src) {
        dest.add(n * n.intValue());
        dest.add(n.doubleValue() * n.doubleValue());
    }
}