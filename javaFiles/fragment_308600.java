Calendar testDate = GregorianCalendar.getInstance();
    testDate.set(2011, 11, 25);

    HolidayManager manager = HolidayManager
            .getInstance(HolidayCalendar.GERMANY);

    Set<Holiday> holidays = manager.getHolidays(2011, "bw");
    for (Holiday h : holidays) {
        System.out.println(h.getDate() + " " + h.getDescription());
    }
    System.out.println(manager.isHoliday(testDate, "bw"));