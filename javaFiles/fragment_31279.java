// It doesn’t matter which time zone we pick
    // since we are discarding it after conversion anyway
    ZonedDateTime zdt = entityDate.atStartOfDay(ZoneOffset.UTC);
    GregorianCalendar gCal = GregorianCalendar.from(zdt);
    XMLGregorianCalendar wsDate = xmlFactory.newXMLGregorianCalendar(gCal);
    wsDate.setTime(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
            DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
    wsDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);