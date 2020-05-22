ZonedDateTime zdt = wsDate.toGregorianCalendar().toZonedDateTime();

    // Validate
    if (! zdt.toLocalTime().equals(LocalTime.MIN)) {
        System.out.println("Warning: time of day will be lost in conversion");
    }
    if (! zdt.getZone().equals(ZoneId.systemDefault())) {
        System.out.println("Warning: UTC offset will be lost in conversion");
    }

    // Finish conversion
    LocalDate entityDate = zdt.toLocalDate();