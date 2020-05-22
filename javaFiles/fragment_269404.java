TimeZone customTimeZone = TimeZone.getTimeZone("GMT-07:00");
    TimeZone officialTimeZone = null;
    for (String timeZoneId : TimeZone.getAvailableIDs()) {
        if (TimeZone.getTimeZone(timeZoneId).hasSameRules(customTimeZone)){
            officialTimeZone = TimeZone.getTimeZone(timeZoneId);
            break;
        }
    }
    ZoneRules zoneRules = ZoneRulesProvider.getRules(officialTimeZone.toZoneId().getId(), true);
    System.out.println(zoneRules);