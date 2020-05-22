public class Foo {
  int maxDayCount = 365;
  String[] days = new String[maxDayCount];
  int finalIndex = 0;

  public static void date(int day) {
    now = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("EEEE d MMMM yyyy");

    String[] days = new String[maxDayCount];      //limits the number of days to print out(ordinarily h)
    now.add(Calendar.DAY_OF_YEAR, day + 1);     //Increments from test count + 1 due to count starting at 0 (would be today). Increments the date to get from today.

    int DayOfWeek = now.get(Calendar.DAY_OF_WEEK);
    boolean WorkingDayCheck = ((DayOfWeek >= Calendar.MONDAY) && (DayOfWeek <= Calendar.FRIDAY));

    if(WorkingDayCheck) {
        days[finalIndex++] = format.format(now.getTime());
        System.out.print("(" + (finalIndex - 1) + ")" + String.valueOf(days[finalIndex - 1]))
    } else {
      //
    }
  }
  public static void main(String[]args) {
    int day = 0;
    while(finalIndex != maxDaysCount) {
      date(day++);
    }
  }
}