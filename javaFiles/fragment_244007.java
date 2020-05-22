@Test
public void testDate() throws ParseException {

    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");

    Date d = fmt.parse("01-Nov-2017");
    System.out.println(d);
    Calendar c = Calendar.getInstance();
    c.setTime(d);
    getSundayBefore1thMondayOfMonth(c);
}

public void getSundayBefore1thMondayOfMonth(Calendar c) {
    c.set(Calendar.DAY_OF_MONTH, 1);
    int wd = c.get(Calendar.DAY_OF_WEEK);
    if (wd > Calendar.MONDAY ) {
        c.add(Calendar.DAY_OF_MONTH, 7);
    }
    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    System.out.println(c.getTime());
    c.add(Calendar.DAY_OF_MONTH, -1);
    System.out.println(c.getTime());
}



Wed Nov 01 00:00:00 CST 2017
Mon Nov 06 00:00:00 CST 2017
Sun Nov 05 00:00:00 CST 2017