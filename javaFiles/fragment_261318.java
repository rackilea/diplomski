boolean foundTZ=false;
for (String availId : TimeZone.getAvailableIDs()){
  if (vTZID.trim().equalsIgnoreCase(TimeZone.getTimeZone(availId).getDisplayName())){
    vTimezone = TimeZone.getTimeZone(availId);
    foundTZ = true;
    break;
  }
}