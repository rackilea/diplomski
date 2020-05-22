Instant now = Instant.now();

GregorianCalendar cal1 = new GregorianCalendar();
cal1.setTimeInMillis(now.toEpochMilli());

XMLGregorianCalendar cal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal1);