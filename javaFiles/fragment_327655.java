public static void main(String[] args) throws ParseException {
    GregorianCalendar gcal = new GregorianCalendar();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    Date start = sdf.parse("2010.01.01");
    Date end = sdf.parse("2010.01.14");
    gcal.setTime(start);
    while (gcal.getTime().before(end)) {
        gcal.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println( gcal.getTime().toString());
    }
}