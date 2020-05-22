SimpleDateFormat formatUTC = new SimpleDateFormat("HHmmss");
    formatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date date = formatUTC.parse("193526");

    SimpleDateFormat formatEDT = new SimpleDateFormat("HH:mm:ss z");
    formatEDT.setTimeZone(TimeZone.getTimeZone("GMT-04:00"));
    System.out.println(formatEDT.format(date));