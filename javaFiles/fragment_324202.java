Map<String, Set<String>> productUpdateMap = productUpdateList
      .stream()
      .collect(Collectors.groupingBy(
               ProductUpdate::getVersionId,
               Collectors.mapping(ProductUpdate::getProductNo, 
                                  Collectors.filtering(Objects::nonNull, 
                                                       Collectors.toSet()))));