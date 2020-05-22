public List<Integer> product(List<Integer> left, List<Integer> right) {
    if (left.size() != right.size()) {
        // A runtime exception you write saying that you can't multiply two
        // arrays of different sizes.
        throw new VectorShapeException(left.size(), right.size());
    }
    List<Integer> vectorProd = new ArrayList<>();
    for (int i = 0; i < left.size(); ++i) {
        vectorProd.add(left.get(i) * right.get(i));
    }
    return vectorProd;
}

public int dotProduct(List<Integer> left, List<Integer> right) {
    return sum(product(left, right));
}