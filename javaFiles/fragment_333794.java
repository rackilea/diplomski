LocalDate from = LocalDate.of(2016, 1, 1);
LocalDate to = LocalDate.of(2017, 1, 1);
long days = from.until(to, ChronoUnit.DAYS);
long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
LocalDate randomDate = from.plusDays(randomDays);
System.out.println(randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));