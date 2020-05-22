GregorianCalendar gregCal = // ...

    ZonedDateTime gregorianDateTime = gregCal.toZonedDateTime();
    System.out.println(gregorianDateTime);
    HijrahDate hijradate = HijrahDate.from(gregorianDateTime);
    System.out.println(hijradate);