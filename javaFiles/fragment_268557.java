import java.io.*;
import java.util.Scanner;

public class Machine{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("U:/op.txt");
        Scanner readfile = new Scanner(file);

        int acc = 0;
        int M1 = 0;

        while(readfile.hasNextInt())
        {
            String read = readfile.nextLine();

            switch(read.substring(0, 2))
            {
                case "01":
                    acc = M1 + Integer.parseInt(read.substring(3, 5));
                    System.out.println(acc);
                break;
            }
        }
    }
}