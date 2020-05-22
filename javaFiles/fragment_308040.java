LocalDate date = LocalDate.parse("2012-10-01");

for (int i = 0; i < 4; i++) {
  System.out.println(date + " - " + date.plusYears(1).minusDays(1));
  date = date.plusYears(1);
}