import java.util.Calendar;

public class PrintDate {

  public PrintDate(){
     //Create this for later
     String year =String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); //Keeping the year 2015

     //Format the date to keep it in a single String
     String date = String.format("0%d0%d%d",
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                (Calendar.getInstance().get(Calendar.MONTH)+1), //Cause the Calendar has January as (0) i add +1
                Integer.valueOf(year.substring(1,4)));  //Make it from 2015 to 15 using Substring Method


     System.out.println(date);
  }

  public static void main(String[] args){
     new PrintDate();
  }
}