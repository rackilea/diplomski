Map<Parent, List<Children>> mapOfParentsAndChildren = new TreeMap<>(
    Comparator.comparing(parent ->
        parent.getChildren().stream()
            .mapToInt(Child::getAge)
            .min().orElse(0)
    )
    .thenComparing(System::identityHashCode)
);