Map<String, List<PlaceSummary>> placesGroupedByPlaceId =
            places.stream()
                  .collect(Collectors.groupingBy(
                          PlaceSummary::getPlaceId,
                          LinkedHashMap::new,
                          Collectors.mapping(Function.identity(), Collectors.toList())
                  ));