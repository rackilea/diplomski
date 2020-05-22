final Map<String, List<Foo>> listMap = 
objectsFromDB.stream().collect(
      Collectors.groupingBy(item -> item.getMailId())
);

for (final Foo feedBackStatus : feedBackStatusFromCsvFiles) {
        listMap.getOrDefault(feedBackStatus.getMailId(), Colleactions.emptyList()).forEach(item -> item.setStatus(feedBackStatus.getStatus()));
}