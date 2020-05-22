DatatypeFactory xmlFactory = DatatypeFactory.newInstance();
    XMLGregorianCalendar wsDate = xmlFactory
            .newXMLGregorianCalendarDate(2019, DatatypeConstants.MARCH, 30,
                    DatatypeConstants.FIELD_UNDEFINED);

    // Validate
    if ((wsDate.getHour() != 0 && wsDate.getHour() != DatatypeConstants.FIELD_UNDEFINED)
            || (wsDate.getMinute() != 0 && wsDate.getMinute() != DatatypeConstants.FIELD_UNDEFINED)
            || (wsDate.getSecond() != 0 && wsDate.getSecond() != DatatypeConstants.FIELD_UNDEFINED)
            || (wsDate.getMillisecond() != 0 && wsDate.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED)) {
        System.out.println("Warning: time of day will be lost in conversion");
    }
    if (wsDate.getTimezone() != DatatypeConstants.FIELD_UNDEFINED) {
        System.out.println("Warning: UTC offset will be lost in conversion");
    }

    // Convert
    LocalDate entityDate = LocalDate.of(wsDate.getYear(), wsDate.getMonth(), wsDate.getDay());
    System.out.println(entityDate);