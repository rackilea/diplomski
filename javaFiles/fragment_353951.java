import java.util.Scanner;
import java.io.*;

public class ReadTextFile
{
  public static void main (String [] args) throws IOException 
  {
    File inFile = new File ("input.txt");

    Scanner sc = new Scanner (inFile);
    while (sc.hasNextLine())
    {
      String line = sc.nextLine();
      System.out.println (line);
    }
    sc.close();
  }
}