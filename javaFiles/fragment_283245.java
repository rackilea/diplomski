LocalDate fromDate = LocalDate.now();
LocalDate toDate = LocalDate.now();

List<LocalDate> dates = new ArrayList<LocalDate>(25);

LocalDate current = fromDate;
//current = current.plusDays(1); // If you don't want to include the start date
//toDate = toDate.plusDays(1); // If you want to include the end date
while (current.isBefore(toDate)) {
    dates.add(current));
    current = current.plusDays(1);
}