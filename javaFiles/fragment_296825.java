import java.util.Scanner;

public class ValuePairSortingSimpler
{
  public static void main(String[] args)
  {
    Scanner scnr = new Scanner(System.in);
    System.out.print("How many schools do you have in your district: ");
    int nos = scnr.nextInt();
    double[] schools = new double[nos];
    System.out.println();

    double ax = 0;

    for (int i = 0; i < nos; i++)
    {
      System.out.println("Enter data for school " + (i + 1));
      System.out.print("   How many students are enrolled in school : ");
      int num = scnr.nextInt();

      System.out.print("   Enter the attendance for day 1: ");
      int d1 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 2: ");
      int d2 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 3: ");
      int d3 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 4: ");
      int d4 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 5: ");
      int d5 = scnr.nextInt();

      double avg = ((d1 + d2 + d3 + d4 + d5) / 5) * 100;
      double att = avg / num;
      schools[i] = att;
      ax = att + ax;

      System.out.println();

      System.out.println("Attendance " + att + "% for school " + (i + 1));
      System.out.println();
    }
    double highest = 0;
    int index = 0;
    for (int i = 0; i < schools.length; i++)
    {
      if (schools[i] > highest)
      {
        index = i;
        highest = schools[i];
      }
    }
    System.out.println("The school with the best attendance is school " + (index + 1) + " with " + highest + "% attendance");
    System.out.print(ax);
  }
}