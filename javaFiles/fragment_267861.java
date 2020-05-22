public static void main(String[] args) throws Exception {
    // Build list of all dates
    String[] txtDates = { "January 20 2015", "February 12 2015", "February 20 2015", "June 21 2015",
            "July 12 2015", "July 28 2015", "July 30 2015", "September 24 2015", "December 31 2015",
            "January 15 2014", "January 15 2015" };
    SimpleDateFormat fmt = new SimpleDateFormat("MMMM d yyyy");
    Date[] allDates = new Date[txtDates.length];
    for (int i = 0; i < txtDates.length; i++)
        allDates[i] = fmt.parse(txtDates[i]);

    // Sort dates, then split them by month
    Arrays.sort(allDates);
    List<List<Date>> datesByMonth = splitByMonth(allDates);

    // Print result
    for (List<Date> dates : datesByMonth) {
        StringBuilder buf = new StringBuilder();
        for (Date date : dates) {
            if (buf.length() != 0)
                buf.append(", ");
            buf.append(fmt.format(date));
        }
        System.out.println(buf);
    }
}