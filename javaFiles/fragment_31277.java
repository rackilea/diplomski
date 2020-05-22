LocalDate entityDate = LocalDate.of(2019, Month.MARCH, 31);

    XMLGregorianCalendar wsDate = xmlFactory.newXMLGregorianCalendarDate(
            entityDate.getYear(),
            entityDate.getMonthValue(),
            entityDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED);
    System.out.println(wsDate);