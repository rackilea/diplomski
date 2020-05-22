import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
  public static void main(String[] args)
  {
    try
    {
      Scanner scanner = new Scanner(new File("words.txt"));
      System.out.println(scanner.nextLine());
      System.out.println(scanner.nextLine());

      Scanner scanner2 = new Scanner(new File("C:\\Users\\prasad.karunagoda\\words2.txt"));
      System.out.println(scanner2.nextLine());
      System.out.println(scanner2.nextLine());
    }
    catch (FileNotFoundException ex)
    {
      ex.printStackTrace();
    }
  }
}