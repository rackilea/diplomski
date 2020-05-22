List<LenderAdditionalPartyTypeEntity> result = cachedTypeNames.stream()
  .map(name -> {
    LenderAdditionalPartyTypeEntity entity = new LenderAdditionalPartyTypeEntity();
    entity.setPartyType(name);
    return entity;
  }).collect(Collectors.toList());