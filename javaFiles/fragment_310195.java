public static Dates getDates() {
  int day = 0, month = 0, year = 0;

  System.out.print("Enter the day: ");
  day = scan.nextInt();

  while (day > 31 || day < 1) {
    System.out.println("Wrong day! repeat entry: ");
    day = scan.nextInt();
  }

  System.out.print("Enter the month: ");
  month = scan.nextInt();

  while(month > 12 || month < 1) {
    System.out.println("Wrong month! repeat entry: ");
    month = scan.nextInt();
  }

  System.out.print("Enter the year: ");
  year = scan.nextInt();
  while(year > 9999 || year < 1800 ) {
    System.out.println("Incorrect Year! repeat entry: ");
    year = scan.nextInt();
  }

  return new Dates(day, month, year);
}