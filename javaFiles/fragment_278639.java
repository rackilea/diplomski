import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Demo 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        File f = new File("boynames.txt");
        Scanner names = new Scanner(f);

        while (names.hasNextLine())
            System.out.println(names.nextLine());
    }
}