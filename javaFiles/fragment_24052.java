public class DateTimeUtils {

    public static void main(String[] args) {

      DateTimeUtils obj = new DateTimeUtils();
      SimpleDateFormat simpleDateFormat = 
               new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

      try {

        Date date1 = simpleDateFormat.parse("10/10/2013 11:30:10");
        Date date2 = simpleDateFormat.parse("13/11/2014 20:35:55");

        obj.printDifference(date1, date2);  

      } catch (ParseException e) {
        e.printStackTrace();
      }

    }

    public void printDifference(Date startDate, Date endDate){

      Interval interval = 
               new Interval(startDate.getTime(), endDate.getTime());
      Period period = interval.toPeriod();

          System.out.printf(
           "%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", 
           period.getYears(), period.getMonths(), period.getDays(),
           period.getHours(), period.getMinutes(), period.getSeconds());

    }
}