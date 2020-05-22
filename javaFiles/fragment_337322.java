abstract class App {
    private final Map<Class<?>, List<Object>> extensions =
        loadExtensions();

    protected final <E> List<E> findExtensions(Class<E> extType) {
        return extensions.entrySet().stream()
                         .filter(e -> extType.isAssignableFrom(e.getKey()))
                         .flatMap(e -> e.getValue().stream())
                         .map(extType::cast)
                         .collect(Collectors.toList());
    }
}