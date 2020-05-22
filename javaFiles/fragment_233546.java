String format = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
//                         ^-^-----check these
// don't pay attention to the smiley generated above, they're arrows ;)
GregorianCalendar cal = new GregorianCalendar();
     cal.setTime(new SimpleDateFormat(format).parse(sampleDate));
     XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar( cal);