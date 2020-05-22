import java.util.Scanner;
import java.io.*;
public class PopData
{
  public static void main(String[] args) throws IOException
  {
  int sum = 0;
  int average = 0;
  int total = 42;
  int high = 0;
  Integer low = null;

  File file = new File("USPopulation.txt");
  Scanner inputFile = new Scanner(file);

  while (inputFile.hasNext())
  {
      int number = inputFile.nextInt();

      sum = sum + number;
      average = sum / total;

      if (number >= high) {
       high = number;
      }
      if( low == null || number < low)
        low = number;
 }
 inputFile.close();
 System.out.println("The average of the numbers is " + average);
 System.out.println(high);
 System.out.println(low);
  } 
}