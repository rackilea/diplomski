private Map<String, List<RelationShip>> groupAndMapRelationships(List<RelationShip> relationShips) {
   return relationShips.stream()
           .collect(Collectors.collectingAndThen(
                   Collectors.groupingBy(RelationShip::getRelationshipType),
                   map -> map.entrySet().stream()
                           .map(e -> new AbstractMap.SimpleEntry<>(
                                   e.getValue().size() == 1 ?
                                           e.getKey().getRelationship() : e.getKey().getRelationshipPlural(),
                                   e.getValue()))
                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
}