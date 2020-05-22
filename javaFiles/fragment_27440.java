private static List<Wrapper> perColumn(List<List<Wrapper>> listOfList) {
    int depth = listOfList.size();
    int max = listOfList.stream().map(List::size).max(Comparator.naturalOrder()).get();
    return IntStream.range(0, max)
            .map(x -> IntStream.range(0, depth)
                    .map(y -> listOfList.get(y).size() < y ? 0 : listOfList.get(y).get(x).getValue())
                    .sum())
            .mapToObj(Wrapper::new)
            .collect(Collectors.toList());
}