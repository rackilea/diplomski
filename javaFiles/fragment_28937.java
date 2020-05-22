import java.io.*;
import java.util.*;

public class UsingLinkedList
{
  public static void main(String[] args)
  {
    System.out.println("Enter meal plan file name :");
    Scanner input = new Scanner(System.in);
    String mealList = input.nextLine().trim();

    List<String> meals = new LinkedList<>();
    try
    {
      File inp1 = new File(mealList + ".txt");
      Scanner inputfile = new Scanner(inp1);
      while (inputfile.hasNextLine())
      {
        meals.add(inputfile.nextLine());
      }
      System.out.println(meals);
    }
    catch (FileNotFoundException exception)
    {
      exception.printStackTrace();
      System.out.println("File not found. Please re-enter the file name.");
    }
  }
}