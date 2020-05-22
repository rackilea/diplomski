String input = "22/Apr/18 10:24 AM";
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy hh:mm a", Locale.ENGLISH);
LocalDate open = LocalDate.parse(input, dtf);
LocalDate now = LocalDate.now();

long diff = ChronoUnit.DAYS.between(open, now);