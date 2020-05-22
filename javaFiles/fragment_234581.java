public class MyDateComparator implements Comparator<Date> {
    protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public int compare(Date d1, Date d2) {
        return DATE_FORMAT.format(d1).compareTo(DATE_FORMAT.format(d2));
    }
}


Date myDate = ...
List<Date> listOfDates = ...
Collections.sort(listOfDates);
int index = Collections.binarySearch(listOfDates, myDate, new MyDateComparator());
if (index >= 0) {
  // you found me
}