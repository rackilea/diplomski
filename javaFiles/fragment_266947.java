import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

    public class StudentParty 

    {
        public static void main(String[] args)

        {
            double total = 0;
            double average;
            String [] name = new String [50];
            Double [] number = new Double [50];

            Scanner fileIn = null;
            PrintWriter OutputStream = null;

            try
            {
                fileIn = new Scanner    
                (new FileInputStream
                        ("StudentPartyInput.txt"));
                OutputStream = new PrintWriter(new FileOutputStream
                        ("StudentPartyOutput.txt")); 
            }

            catch (FileNotFoundException e)
            {
                System.out.println("File not found.");
                System.exit(0);
            }
             int cnt=0;
            while (fileIn.hasNextLine())
                    {
                        name[cnt]=fileIn.nextLine();
                        number[cnt] = Double.valueOf(fileIn.next());
                        total = total + number[cnt];
                        cnt++;
                        if(fileIn.hasNextLine()) fileIn.nextLine();
                    }

            average = total / (double)cnt; 
            fileIn.close();
            OutputStream.println(); 
            OutputStream.println(name[0] + " had " + (number[0] - average) + " more drinks than the average ");
            OutputStream.println(name[1] + " had " + (number[1] - average) + " more drinks than the average ");
            OutputStream.println(name[2] + " had " + (number[2] - average) + " more drinks than the average ");
            OutputStream.close();   
        }

    }