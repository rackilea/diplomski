import java.io.*;
import java.util.*;

    public class Main
    {
        public static void main(String[] args) throws FileNotFoundException {
            System.out.println(System.getProperty("user.dir"));
            File file = new File(System.getProperty("user.dir") + "/src/report.txt");
            Scanner hemp = new Scanner(file);
            while (hemp.hasNextLine()) 
              System.out.println(hemp.nextLine());
        }
    }