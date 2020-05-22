import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class Triangle {

public static void main (String[] args)
{

    File fileName = new File("input.txt");
    Scanner scan = null;
    String str[];
    int s1=0,s2=0,s3=0;
try 
{ 
    Scanner file = new Scanner( new File("input.txt"));
    String line;
    while((line=file.nextLine())!=null)
    {
        str = line.split(" ");

        if(str.length==3)
        {
            try
            {
                s1 = Integer.parseInt(str[0]);
                s2 = Integer.parseInt(str[1]);
                s3 = Integer.parseInt(str[2]);

                if(s1+s2>=s3 && s2+s3>=s1 && s1+s3>=s2)
                {
                    if(s1==s2 && s2==s3) System.out.println("Equilateral");
                    else if(s1==s2 || s2==s3 || s3==s1) System.out.println("Isosceles");
                    else System.out.println("Scalene");
                }
                else
                {
                    System.out.println("Not a Triangle");
                }
            }
            catch(Exception e)
            {
                System.out.println("Not a Triangle");
            }

        }
        else
        {
            System.out.println("Not a Triangle");
        }
    }
}
catch(Exception e)
{

}

}

}