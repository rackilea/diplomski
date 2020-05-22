Scanner s = new Scanner(System.in);
System.out.println("Please enter your birthday. Format: DD.MM.YYYY");
String bday = s.nextLine();

LocalDate ld = LocalDate.parse(bday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
System.out.println("DayOfWeek = " + ld.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));