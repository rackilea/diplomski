List<Element> elements = new ArrayList<>(Arrays.asList(element));
// or
List<Element> elements = new ArrayList<>(Collections.singletonList(element));
//or
List<Element> elements = Stream.of(element)
                               .collect(toCollection(ArrayList::new));