public class ProjectUtils <T, S> {

    public static <T, S> Map<S, T> collectionToMap(Collection<T> collection, Function<T, S> fieldExtractor) {
        return collection.stream().collect(Collectors.toMap(fieldExtractor, Function.identity()));
    }
}