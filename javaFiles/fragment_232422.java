import java.io.*;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //try block starts here
        try {  
            File f = new File (new File("SPY.txt").getAbsolutePath());
            System.out.println(f.exists());
            Scanner s = new Scanner(f);
        } 
        //catch the exception
        catch(FileNotFoundException e) {
            e.printStackTrace();   
        }

    }
}