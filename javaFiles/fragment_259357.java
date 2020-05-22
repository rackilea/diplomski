Set<UniqueZone> uniqueZones = ZoneId
    // get all IDs
    .getAvailableZoneIds().stream()
    // map to a UniqueZone (so zones with the same ZoneRules won't be duplicated)
    .map(zoneName -> new UniqueZone(ZoneId.of(zoneName)))
    // create Set
    .collect(Collectors.toSet());