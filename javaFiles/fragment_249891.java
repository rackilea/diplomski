List<DetailObject> newDetails = details.stream()
  .map(detail -> {
    return masters.stream()
      .filter(master -> filterLoans(detail, master))
      .map(master -> createDetail(detail, master))
      .collect(Collectors.toList());
  })
  .flatMap(List::stream)
  .collect(Collectors.toList());