String str = "2018-09-22T12:30:10Z";
    OffsetDateTime dateTime = OffsetDateTime.parse(str);
    DayOfWeek dow = dateTime.getDayOfWeek();
    if (dow.equals(DayOfWeek.SATURDAY) || dow.equals(DayOfWeek.SUNDAY)) {
        dateTime = dateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
    System.out.println(dateTime);