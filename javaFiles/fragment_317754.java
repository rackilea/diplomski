public List<GroupedOrderActionUpdateEntity> convertAndGroupForUpdate(
                                            List<SimpleRatifiableAction> actions) {
    return actions.stream()
      .collect(Collectors.groupingBy( // use List.of(…, …) in Java 9 or newer
               x -> Arrays.asList(x.getOrderNumber(), x.getActionType())))
      .values().stream()
      .map(x -> convertToUpdateGroup(x))
      .collect(Collectors.toList());
}