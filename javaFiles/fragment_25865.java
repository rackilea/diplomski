// TODO: Which time zone are you interested in?
YearMonth yearMonth = YearMonth.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
List<String> dates = new ArrayList<>();
for (int i = 0; i < 6; i++) {
    dates.add(formatter.format(yearMonth.plusMonths(i)));
}