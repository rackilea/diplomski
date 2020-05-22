List<String> featureNames =
    features.values()
            .stream()
            .filter(feature - > feature.getGroup() != null && feature.getGroup().getGroupId().equals(groupId))
            .map(feature -> feature.getName()) // or .map(Feature::getName)
            .collect(Collectors.toList());