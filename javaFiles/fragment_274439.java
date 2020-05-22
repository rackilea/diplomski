<T> Set<String> trimNumberList(Set<String> criteria, Function<String, T> valueOf, Predicate<T> isWellFormed){
    Set<String> validData = new HashSet<>();
    Set<T> numberList = criteria.stream().map(String::trim).map(valueOf)
            .filter(isWellFormed).collect(Collectors.toSet());
    for (T num : numberList) {
        // Do somehing with validData
    }
    return validData;
}