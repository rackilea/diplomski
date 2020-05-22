static void collectByMethodReference(Collection<String> list) {
    Collection<Integer> collected = list.stream().collect(Collectors.collectingAndThen(
            Collectors.groupingBy(String::length),
            java.util.Map::keySet
    ));
}