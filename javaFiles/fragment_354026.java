String input = "(UTC+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius";
// assuming the format is always fixed at the beginning
String timeZoneOffset = input.substring(4,10);

// needs to be initialized somewhere
Map<String, TimeZone> timeZones = new HashMap<>();
// you need to add all offsets
timeZones.put("+02:00", TimeZone.getTimeZone("EET"));

System.out.println("timeZone lookup = " + timeZones.get(timeZoneOffset));