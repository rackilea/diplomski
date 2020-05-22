int addWeek = 0;
if(startDate.get(WeekFields.ISO.weekOfYear()) < endDate.get(WeekFields.ISO.weekOfYear())){
    addWeek = 1;
}
long weeks = WEEKS.between(startDate, endDate) + addWeek;//Get the number of weeks in your case (52)
List<Integer> numberWeeks = new ArrayList<>();
if (weeks >= 0) {
    int week = 0;
    do {
        //Get the number of week
        int weekNumber = startDate.plusWeeks(week).get(WeekFields.ISO.weekOfYear());
        numberWeeks.add(weekNumber);
        week++;
    } while (week <= weeks);
}