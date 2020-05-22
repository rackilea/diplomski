public class Example<E extends Example<E>> {
    public <E extends Example<E>> List<E> toExamples(Collection<String> collection) {
        return collection.stream()
            .collect(Collectors.mapping(v -> lookup(v), Collectors.toList()));
    }

    public static <E extends Example<E>> E lookup(String value) {
        return null;
    }
}