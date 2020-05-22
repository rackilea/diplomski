Map<String, Map<String, String>> PartDetailsHMap = new HashMap<>();
    List<Part> partList = new ArrayList<>();

    Map<Part, Map<String, String>> collectingPartMap = partList.stream()
      .map(part -> PartDetailsHMap.values()
        .stream()
        .filter(partPropsHMap -> partPropsHMap.containsValue(part.getPropertyValue("part_id")))
        .findFirst()
        .map(partPropsHMap -> new SimpleEntry<Part, Map>(part, partPropsHMap))
        .get()
      )
      .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));