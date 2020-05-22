final Map<String, Map<Integer, ResourceCount>> destMap = map.entrySet().stream().collect(
        Collectors.toMap(entry -> entry.getKey().getCityId(), Map.Entry::getValue, (resMap1, resMap2) -> {
            return Stream.of(resMap1, resMap2).flatMap(m -> m.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (rc1, rc2) -> new ResourceCount(
                                    rc1.getStreetLightCount() + rc2.getStreetLightCount(),
                                    rc1.getWaterTankCount() + rc2.getWaterTankCount())));
        }));