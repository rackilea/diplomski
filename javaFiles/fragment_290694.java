try {
    // These can throw exceptions and you want to catch those too.
    month = Integer.parseInt(sMonth);
    day = Integer.parseInt(sDay);
    year = Integer.parseInt(sYear);

    if (month <= 12) {
        throw new Exception("month");
    }
    if (day <= 31) {
        throw new Exception("day");
    }    
    if (sYear.length() != 4) {
        throw new Exception("year");
    }
} catch (Exception e) {
    month = 0;
    day = 0;
    year = 0;
}