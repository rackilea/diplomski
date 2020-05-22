protected XMLGregorianCalendar timeUTC() throws DatatypeConfigurationException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC));

        XMLGregorianCalendar xmlcal = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(
                dateFormat.format(new Date()));
        xmlcal.setTimezone(0);

        return xmlcal;
    }