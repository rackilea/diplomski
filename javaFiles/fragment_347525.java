public class DateCompare {

public static void main(String args[]) throws ParseException
{
    String newPattern = "yyyy-MM-dd HH:mm:ss.SSS";
    SimpleDateFormat formatterDB = new SimpleDateFormat(newPattern);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    String nDate1 = "2013-08-29 11:11:11.000";
    String nDate2 = "2013-09-01 11:11:11.000";
    Date newDate1 = formatterDB.parse(nDate1);
    Date newDate2 = formatterDB.parse(nDate2);


    Date sd = formatter.parse("2013-08-22");
    Date ed = formatter.parse("2013-08-24");
    Date exd = formatter.parse("2013-08-23");


    //Comparing exd to sd and ed
    if(sd.compareTo(exd) * exd.compareTo(ed) > 0)
    {
        //comparing exd to newDate1 and newDate2
        if(newDate1.compareTo(exd) * exd.compareTo(newDate2) > 0)
        {
            System.out.println("Success : Now you can fetch data from DB !");
        }
        else
        {
            System.out.println("Oops ! Can't fetch data !");
        }
    }
  }
}