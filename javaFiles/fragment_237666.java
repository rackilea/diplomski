private static List<Element> getTheNewList(List<Element> elements) {
    int halfElements = elements.size() / 2;
    return Stream.concat(
            IntStream.range(0, halfElements)
                    .mapToObj(index -> new Element(elements.get(index * 2).getFitness() + elements.get(index * 2 + 1).getFitness())),
            elements.stream().limit(halfElements + 1)
    )
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
}