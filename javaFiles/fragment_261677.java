List<GroupOfEntity> groupEntities = listOfEntities.stream()
        .collect(Collectors.groupingBy(Entity::getEntityPk))
        .entrySet().stream()
        .map(e -> new GroupOfEntity(e.getKey().getPeriodMonth(),
                                    e.getKey().getPeriodYear(),
                                    e.getValue()))
        .collect(Collectors.toList());