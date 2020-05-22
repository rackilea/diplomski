SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
String earliestRunTime = "2017-12-16 01:30:08.0";
Date currentDate = new Date();
log.info("Current Date: {}" + format.format(currentDate));

try {
    Date earliestDate = format.parse(earliestRunTime);

    long diff = currentDate.getTime() - earliestDate.getTime();

    long diffSeconds = diff / 1000L % 60L;
    long diffMinutes = diff / (60L * 1000L) % 60L;
    long diffHours = diff / (60L * 60L * 1000L) % 24L;
    long diffDays = diff / (24L * 60L * 60L * 1000L) % 30L;
    long diffMonths = diff / (30L * 24L * 60L * 60L * 1000L) % 12L;
    long diffYears = diff / (12L * 30L * 24L * 60L * 60L * 1000L);

    return String.format("%s years, %s months, %s days, %s hours, %s minutes, %s seconds",
            diffYears, diffMonths, diffDays, diffHours, diffMinutes, diffSeconds);


}
catch (Exception e) {
    e.printStackTrace();
    return e.getMessage();
}