static Pattern CITY_PATTERN=Pattern.compile(
    "([^:]*):([^:]*):(\\d+)° (\\d+)' ([NS]):(\\d+)° (\\d+)' ([WE])");

static City parseCity(String line) {
    Matcher matcher = CITY_PATTERN.matcher(line);
    if(!matcher.matches())
        throw new IllegalArgumentException(line+" doesn't match "+CITY_PATTERN);
    City city=new City();
    city.setProvince(matcher.group(1));
    city.setCity(matcher.group(2));
    city.setLatitudeDegrees(Integer.parseInt(matcher.group(3)));
    city.setLatitudeMinutes(Integer.parseInt(matcher.group(4)));
    city.setLatitudeDirection(line.charAt(matcher.start(5)));
    city.setLongitudeDegrees(Integer.parseInt(matcher.group(6)));
    city.setLongitudeMinutes(Integer.parseInt(matcher.group(7)));
    city.setLongitudeDirection(line.charAt(matcher.start(8)));
    return city;
}