List<LocalDate> weekDates = new ArrayList<>();
LocalDate tmp = getFirstDate().dayOfWeek().withMinimumValue();
// Loop until we surpass end date
while(tmp.isBefore(getEndDate())) {
   weekDates.add(tmp);
   tmp = tmp.plusWeeks(1);
}