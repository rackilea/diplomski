List<String> featureNames =
    features.entrySet()
            .stream()
            .filter(entry -> entry.getValue().getGroup() != null && entry.getValue().getGroup().getGroupId().equals(groupId))
            .map(entry -> entry.getValue().getName())
            .collect(Collectors.toList());