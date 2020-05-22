final Map<String, List<String>> region1 = new LinkedHashMap<>();
region1.put("R1", new ArrayList<>(Arrays.asList("A", "B", "C", "D")));

final Map<String, List<String>> region2 = new LinkedHashMap<>();
region2.put("R2", new ArrayList<>(Arrays.asList("A", "G", "C", "B")));
region2.put("R3", new ArrayList<>(Arrays.asList("A", "G", "C", "B")));

final Stream<Entry<String, List<String>>> entries =
        region1.values()
               .stream()
               .flatMap(values ->
                       region2.entrySet()
                              .stream()
                              .map(e -> {
                                  final List<String> value =
                                          e.getValue()
                                           .stream()
                                           .filter(v -> !values.contains(v))
                                           .collect(toList());
                                  return new SimpleEntry<>(e.getKey(), value);
                              })
               );

final Map<String, List<String>> result = entries.collect(toMap(Entry::getKey, Entry::getValue));