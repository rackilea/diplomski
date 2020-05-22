public static <T> List<T> search(Collection<T> collectionObject,
        Function<T, String> searchPropertyAccessor, String searchText) {     

    List<T> result = collectionObject.stream()
        .filter(item -> Objects.equals(searchPropertyAccessor.apply(item), searchText))
        .collect(Collectors.toList());
}