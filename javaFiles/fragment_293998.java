public List<?> flatten(List<?> input) {
    List<Object> result = new ArrayList<Object>();

    for (Object o: input) {
        if (o instanceof List<?>) {
            result.addAll(flatten((List<?>) o));
        } else {
            result.add(o);
        }
    }

    return result;
}