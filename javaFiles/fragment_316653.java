// Edit: Since the type of the input `Collection` is not bound strictly
List<Object> flatten(Collection<?> input) {
    List<Object> concatenated = new ArrayList<>();
    for (Object v : input) {
        if (v instanceof Collection) {
            concatenated.addAll(flatten((Collection<?>) v));
        } else {
            concatenated.add(v);
        }
    }
    return concatenated;
}