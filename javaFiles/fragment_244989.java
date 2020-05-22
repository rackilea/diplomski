class SetToListTransformer<T> implements Transformer<Set<? extends T>, List<T>> {

    @Override
    public List<T> transform(final Set<? extends T> input) {
        final List<T> output = new ArrayList<T>(input.size());
        output.addAll(input);
        return output;
    }
}