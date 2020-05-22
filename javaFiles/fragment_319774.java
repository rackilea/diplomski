Pattern NMEA_PATTERN = Pattern.compile(
                ".*Latitude: (\\d{4}.\\d+).*" + 
                "Longitude: (\\d{5}.\\d+).*");
Matcher m = NMEA_PATTERN.matcher(gpsSentence);

if (m.matches()) {
    String latitude = m.group(1);
    String longitude = m.group(2);
    ...
}