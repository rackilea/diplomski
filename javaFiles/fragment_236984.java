public int calculateDate(int month, int day, int year, int numOfDays) {
    LocalDate ld = LocalDate.of(year, month, day).plusDays(numOfDays);
    dMonth = ld.getMonthValue();
    dDay = ld.getDayOfMonth();
    return dDay;
}