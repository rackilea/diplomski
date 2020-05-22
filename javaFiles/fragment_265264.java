public void prepare() throws Exception {
    String[] monthNames = new DateFormatSymbols().getMonths();
    int i = 1;
    for (String monthName : monthNames) {
        months.put(i++, monthName);
    }
}