import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class DailyTemperatureList
{
  public static void main (String [] args)
  {

    ArrayList<DailyTemperature> dailytemps = new ArrayList<DailyTemperature>();

    dailytemps.add(new DailyTemperature("Mon", 87.1));
    dailytemps.add(new DailyTemperature("Tue", 88.3));
    dailytemps.add(new DailyTemperature("Wed", 81.2));
    dailytemps.add(new DailyTemperature("Thu", 84.0));
    dailytemps.add(new DailyTemperature("Fri", 76.3));

    System.out.println( "original list:" );
    System.out.println( dailytemps.toString() );

    insertionSort( dailytemps);
    System.out.println( "sorted list:" );
    System.out.println( dailytemps.toString() );



  }

  //public static <DailyTemperature extends Comparable<? super DailyTemperature>>
  static void insertionSort(ArrayList<DailyTemperature> dailytemps)
  {
    DailyTemperature temp = null;
    int position = 0;

    //loop from 2nd element on
    for (int i = 1; i < dailytemps.size(); i++)
    {
      temp = dailytemps.get(i);
      position = i;

      while ( 0 < position && temp.compareTo(dailytemps.get(position - 1 )) < 0)
      {
        dailytemps.set(position, dailytemps.get(position - 1));
        position--;
      }
      dailytemps.set(position,temp);
    }
  }






}