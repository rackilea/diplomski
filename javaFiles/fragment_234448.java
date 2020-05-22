public Date parseDate(String userString) {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy mm:HH");
    try {
        return df.parse(userString);
    } catch (ParseException e) {
        LOGGER.error("Could not parse date '" + userString + "' reverting to default");
        try {
            return df.parse("07/12/2016 01:00");
        } catch (ParseException shouldntHappen) {
            throw new RuntimeException(shouldntHappen);
        }
    }
}