LocalDate startDate = new LocalDate(2011, 11, 8);
LocalDate endDate = new LocalDate(2012, 5, 1);

startDate = startDate.withDayOfMonth(1);

while (!startDate.isAfter(endDate)) {
    System.out.println("> " + startDate);
    startDate = startDate.plusMonths(1);
    LocalDate endOfMonth = startDate.minusDays(1);
    System.out.println("< " + endOfMonth);
}