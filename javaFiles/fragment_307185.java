public LinkedList<Q> transformAll(Node L, UnaryTransformer<Q> R) {
    if (L == null) {
        return null;
    }

    LinkedList<Q> sequence = new LinkedList<>();

    for (int i = 0; i < size(); i++) {
        sequence.add(R.apply(get(i)));
    }

    return sequence;
}