long oneMonthInNanos = ChronoUnit.MONTHS.getDuration().toNanos();
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Phnom_Penh"));

    System.out.println("Now           " + now);
    System.out.println("In 3.5 months " + now.plusNanos(Math.round(3.5 * oneMonthInNanos)));
    System.out.println("In 4.5 months " + now.plusNanos(Math.round(4.5 * oneMonthInNanos)));
    System.out.println("In 12 months  " + now.plusNanos(Math.round(12.0 * oneMonthInNanos)));