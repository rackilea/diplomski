LocalDate now = LocalDate.now();
int year = now.getYear();
List<LocalDate> dates = ...;
List<LocalDate> adjusted = new ArrayList<>(10);
for (LocalDate date : dates) {
    LocalDate warped = date.withYear(year);
    if (warped.isBefore(now)) {
        warped = warped.withYear(year + 1);
    }
    adjusted.add(warped);
}