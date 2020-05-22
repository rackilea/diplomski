final DateFormat format = new SimpleDateFormat("E. M/d");
final String dateStr = "Thu. 03/01";
final Date date = format.parse(dateStr);

GregorianCalendar gregory = new GregorianCalendar();
gregory.setTime(date);

XMLGregorianCalendar calendar = DatatypeFactory.newInstance()
        .newXMLGregorianCalendar(
            gregory);