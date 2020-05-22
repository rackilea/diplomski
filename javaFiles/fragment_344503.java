public List<Integer> sum(List<Integer> left, List<Integer> right) {
    if (left.size() != right.size()) {
        // A runtime exception you write saying that you can't add two
        // arrays of different sizes.
        throw new VectorShapeException(left.size(), right.size());
    }
    List<Integer> vectorSum = new ArrayList<>();
    for (int i = 0; i < left.size(); ++i) {
        vectorSum.add(left.get(i) + right.get(i));
    }
    return vectorSum;
}