// TODO: Which time zone are you interested in?
YearMonth yearMonth = new YearMonth();
DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMM");
List<String> dates = new ArrayList<>();
for (int i = 0; i < 6; i++) {
    dates.add(formatter.print(yearMonth.plusMonths(i)));
}