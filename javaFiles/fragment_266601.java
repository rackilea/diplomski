static List<String> getListOfValuesByItemNumber( 
            Map<String, Collection<Map<String, String>>> map,
            String itemNumber){

        return map.values()
                .stream()
                .flatMap(Collection::stream)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .filter(e -> e.getKey().equals(itemNumber))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
}