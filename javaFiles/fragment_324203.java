Map<String, Set<String>> productUpdateMap = productUpdateList
      .stream()
      .collect(Collectors.groupingBy(
               ProductUpdate::getVersionId, 
               Collectors.flatMapping(pu -> Stream.ofNullable(pu.getProductNo()), 
                                      Collectors.toSet())));