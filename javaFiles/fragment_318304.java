DateTimeZone zone = DateTimeZone.forID(timezoneId);
DateTimeFormatter formatter = DateTimeFormat
                      .forPattern("dd/MM/yyyy HH:mm:ss")
                      .withZone(zone);
DateTime tzDate = formatter.parseDateTime(timeAsString).withZone(zone);
return tzDate;