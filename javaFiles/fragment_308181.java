// 1. Convert the Set as a Stream of List<Map<String, List<Object>>>
// 2. Extract the elements of the lists to get a Stream of Map<String, List<Object>>
// 3. Extract values of the maps to get a Stream of List<Object>
// 4. Extract the elements of the lists to get a Stream of Object
// 5. Get rid of duplicates
// 6. Collect the result as a List of Object
List<Object> result = complexNestedCollection.stream()
    .flatMap(List::stream)
    .flatMap(m -> m.values().stream())
    .flatMap(List::stream)
    .distinct()
    .collect(Collectors.toList());