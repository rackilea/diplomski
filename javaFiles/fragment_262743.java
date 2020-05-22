public class CalendarItem implements Comparable<CalendarItem> {
    private int index;
    private String description;
    private ZonedDateTime textdate;
    private long daysAway = 0;

    public CalendarItem(int index, String description, ZonedDateTime textdate) {
        this.index = index;
        this.description = description;
        this.textdate = textdate;
        this.calculateDaysAway();
    }

    private void calculateDaysAway() {
        this.daysAway = ChronoUnit.DAYS.between(textdate, ZonedDateTime.now(ZoneId.systemDefault()));
    }

    public long getDaysAway() {
        return daysAway;
    }

    @Override
    public int compareTo(CalendarItem o) {
        if (this.daysAway < o.daysAway) {
            return -1;
        } else if (this.daysAway > o.daysAway) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        CalendarItem c1 = 
                new CalendarItem(0, "One", ZonedDateTime.of(2018, 5, 21, 0, 0, 0, 0, ZoneId.systemDefault()));
        CalendarItem c2 = 
                new CalendarItem(0, "Two", ZonedDateTime.of(2018, 5, 4, 0, 0, 0, 0, ZoneId.systemDefault()));
        CalendarItem c3 = 
                new CalendarItem(0, "Three",ZonedDateTime.of(2018, 5, 11, 0, 0, 0, 0, ZoneId.systemDefault()));
        CalendarItem c4 = 
                new CalendarItem(0, "Four", ZonedDateTime.of(2018, 5, 1, 0, 0, 0, 0, ZoneId.systemDefault()));

        List<CalendarItem> calendarItems = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));

        Collections.sort(calendarItems);

        for (CalendarItem item : calendarItems) {
            System.out.println("Item " + item.getDescription() + " is " + item.getDaysAway() + " days away.");
        }
    }
}