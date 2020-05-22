LocalDate limit = now.plusDays(30);
for (LocalDate date : adjusted) {
    if ((date.isAfter(now) || date.isEqual(now)) && (date.isBefore(limit) || date.isEqual(limit))) {
        System.out.println("~~ " + date);
    }
}