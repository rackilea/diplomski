//Calculates Year difference
public static int getYeardiff(Dates other) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("Press <0>, if you want to know passed years between two dates. ");
  int difference = 0;
  int key = scan.nextInt();
  if(key == 0) {
    System.out.println("Enter a second date: ");

    Dates diffr = getDates();

    difference = Math.abs(diffr.year - other.year);
    System.out.println(difference);
  }
  return difference;
}

//Formats the date into a String.
public static String asString(Dates other) {
  String stringDay = "" + other.day;
  String stringMonth = "" +other.month;
  String stringYear = "" + other.year;
  String stringDate = stringDay + "." + stringMonth+ "." + stringYear;
  System.out.println(stringDate);
  return stringDate;
}