List<LocalDate> dates = new ArrayList<LocalDate>();
int days = Days.daysBetween(startDate, endDate).getDays()+1;
for (int i=0; i < days; i++) {
    LocalDate d = startDate.withFieldAdded(DurationFieldType.days(), i);
    dates.add(d);
}