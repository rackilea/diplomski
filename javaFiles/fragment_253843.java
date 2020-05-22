import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaApplication32 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner scanner1 = null;
        Scanner scanner2 = null;
        String partCheck;
        String repeatLoop;
        boolean isInOne;
        boolean isInTwo;

        File file1 = new File("data1.txt");
        File file2 = new File("data2.txt");

        try
        {
            scanner1 = new Scanner(file1);
            scanner2 = new Scanner(file2);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
            do
            {
                isInOne = false;
                isInTwo = false;
                System.out.println("Enter the part number");
                partCheck = keyboard.nextLine();
                while (scanner1.hasNextLine() && !isInOne)
                {
                    String line = scanner1.nextLine();
                    if(line.equals(partCheck))
                    {
                        System.out.println("Part Number exists in 1");
                        isInOne = true;
                    }
                }
                if(!isInOne)
                {
                    System.out.println("Part Number does not exist in 1");
                }
                while(scanner2.hasNextLine() && !isInOne && !isInTwo)
                {
                    String line = scanner2.nextLine();
                    if(line.equals(partCheck))
                    {
                        System.out.println("Part Number exists in 2");
                        isInTwo = true;
                    }
                }
                if(!isInTwo)
                {
                    System.out.println("Part Number does not exist in 2");
                }
                System.out.println("Do you want to continue? (Y/N)");
                repeatLoop = keyboard.nextLine();
            } while(repeatLoop.equalsIgnoreCase("y"));
        scanner1.close();
        scanner2.close();
    }
}