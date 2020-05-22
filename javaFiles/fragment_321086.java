import java.io.*;
import java.util.*;
public class Mine
{
    public static void main(String[] args)
    {
        Scanner inFile = null;
        PrintWriter outFile = null;
        try {
            try {
                inFile = new Scanner(new FileReader("Ch3_Ex7Data.txt"));
                outFile = new PrintWriter("Ch3_Ex7Output.dat");

                String lastName;
                lastName = inFile.next();
                System.out.println(lastName);
            } finally {
                if(inFile != null)
                    inFile.close();
                if(outFile != null)
                    outFile.close();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}