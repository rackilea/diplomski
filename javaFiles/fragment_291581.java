System.out.println("Year  DOW  ISO      US");
    for (int year = 2010; year <= 2020; year++) {
        LocalDate jan1 = LocalDate.of(year, Month.JANUARY   , 1);
        System.out.format(Locale.ROOT, "%4d  %3s  %4d-%02d  %4d-%02d%n",
                year, jan1.getDayOfWeek().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ROOT), 
                jan1.get(WeekFields.ISO.weekBasedYear()), jan1.get(WeekFields.ISO.weekOfWeekBasedYear()), 
                jan1.get(WeekFields.SUNDAY_START.weekBasedYear()), jan1.get(WeekFields.SUNDAY_START.weekOfWeekBasedYear()));
    }