@Test
public void testDate() throws ParseException {

    int year = 2011, month = 12, date = 20;

    Calendar calendar = Calendar.getInstance();

    calendar.set(year, month - 1, date);

    Date javaDate = calendar.getTime();

    // SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy");

    DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);

    String stringDate = format.format(javaDate);

    assertEquals("Dec 20, 2011", stringDate);

}