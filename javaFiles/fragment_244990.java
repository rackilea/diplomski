class MyTransformers {

    // There is no reason to expose SetToListTransformer now.
    // Keep it here as an anonymous class.
    private static final Transformer<Set<?>, List<?>> FROM_SET_TO_LIST =
            new Transformer<Set<?>, List<?>>() {
                @Override
                public List<?> transform(final Set<?> input) {
                    return doTransform(input);
                }
                private <T> List<T> doTransform(final Set<T> input) {
                    final List<T> output = new ArrayList<T>(input.size());
                    output.addAll(input);
                    return output;
                }
            };

    private MyTransformers() { }

    public static <T> Transformer<Set<? extends T>, List<T>> fromSetToList() {
        @SuppressWarnings("unchecked")//this is okay for any T because the impl is stateless 
        final Transformer<Set<? extends T>, List<T>> withNarrowedTypes =
                (Transformer<Set<? extends T>, List<T>>)(Transformer<?, ?>)FROM_SET_TO_LIST;
        return withNarrowedTypes;
    }
}