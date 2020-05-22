import java.util.Scanner;
import java.io.*;

public class Project3
{
    public static void main(String[] args) throws IOException
  {

      int m1, d1, y1, m2, d2, y2;
      Scanner scan = new Scanner(new FileReader("dates.txt"));

      for(int i = 0 ; i < 6; ++i)
      {

          m1 = scan.nextInt();
          d1 = scan.nextInt();
          y1 = scan.nextInt();

          m2 = scan.nextInt();
          d2 = scan.nextInt();
          y2 = scan.nextInt();

          System.out.println("The total number of days between the dates you entered are: " + x(m1, d1, y1, m2, d2, y2));
      }
  } 
public static int x (int m1, int d1, int y1, int m2, int d2, int y2)  {
    int total = 0;
    total = d2 - d1 + 1;
    if (y1 == y2) {
        for(int i = m1; i < m2 ; ++i) {
            total += daysInMonth(i, y2);
        }
    } else {
        for (int i = m1; i <= 12; i++) {
            total += daysInMonth(i, y1);
        }
        for (int i = y1+1; i < y2; i++) {
            total += daysInYear(i);
        }
        for (int i = 1; i < m2 ; i++) {
            total += daysInMonth(i, y2);
        }
    }
    return total;
}

//Methods       
 public static boolean isLeap(int yr)
{
  if(yr % 400 == 0)
     return true;
  else if (yr % 4 == 0 && yr % 100 !=0)
     return true;
  else return false;

 }

  public static int daysInMonth( int month , int year)
 {  
  int leapMonth;

  if (isLeap(year) == true)
  {
     leapMonth = 29;
  }
  else
  {
     leapMonth = 28;
  }

  switch(month)
  {
     case 1:
     case 3:
     case 5:
     case 7:
     case 8:
     case 10:
     case 12: return 31;
     case 4:
     case 6:
     case 9:
     case 11: return 30;
     case 2: return leapMonth;
     }
   return 28;     
  }

 public static int daysInYear(int year)
 { 
  if (isLeap(year))
     return 366;
  else 
     return 365;

 }
}