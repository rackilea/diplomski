Optional<Long> root = Optional.of(basedOnObject.getObjectId());
list.stream()
    .map(DbObject::getBasedOnObjectId)
    .map(Optional::ofNullable)
    .filter(root::equals)
    .collect(Collectors.toList());