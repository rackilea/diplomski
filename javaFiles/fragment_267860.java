@SuppressWarnings("null")
private static List<List<Date>> splitByMonth(Date ... dates) {
    List<List<Date>> datesByMonth = new ArrayList<>();
    List<Date> monthList = null;
    int currYear = 0, currMonth = -1;
    Calendar cal = Calendar.getInstance();
    for (Date date : dates) {
        cal.setTime(date);
        if (cal.get(Calendar.YEAR) != currYear || cal.get(Calendar.MONTH) != currMonth) {
            monthList = new ArrayList<>();
            datesByMonth.add(monthList);
            currYear = cal.get(Calendar.YEAR);
            currMonth = cal.get(Calendar.MONTH);
        }
        monthList.add(date);
    }
    return datesByMonth;
}