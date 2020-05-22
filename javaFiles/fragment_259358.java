// zone names to be excluded
Set<String> excludedNames = new HashSet<>();
excludedNames.add("Asia/Chungking");
excludedNames.add("Asia/Chongqing");

Set<UniqueZone> uniqueZones = ZoneId
    // get all IDs
    .getAvailableZoneIds().stream()
    // filter names I don't want
    .filter(zoneName -> ! excludedNames.contains(zoneName))
    // map to a UniqueZone (so zones with the same ZoneRules won't be duplicated)
    .map(zoneName -> new UniqueZone(ZoneId.of(zoneName)))
    // create Set
    .collect(Collectors.toSet());