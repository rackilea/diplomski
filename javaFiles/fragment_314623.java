List<ClassName> result = new ArrayList<>();
List<Iterator<ClassName>> iterators = map.values().stream()
        .map(List::iterator).collect(Collectors.toList());
while (iterators.stream().anyMatch(Iterator::hasNext))
    iterators.stream().filter(Iterator::hasNext).map(Iterator::next).forEach(result::add);

System.out.println(result);