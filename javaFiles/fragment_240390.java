//Java jEdit
import java.util.Scanner;
import java.io.*;

public class TempDriver {
    public static void main(String[] args) {
        //The array were you are going to put the data
        double[] temp = new double[12];
        //The Scanner you are going to read the numbers from
        Scanner file = new Scanner(new File("myfile.dat"));
        //Calling readFile()
        temp = TempDriver.readFile(temp, file);
        //Close the Scanner now that you are done using it
        file.close();
        //TODO: Display your fetched data here
    }

    public static double[] readFile(double[] temp, Scanner file){
        int i = 0;
        try {
            //Read numbers
            while (file.hasNextDouble()) {
                temp[i] = file.nextDouble();
                i++;
            }
        } catch(FileNotFoundException e){
            System.out.println ("File not found");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println ("Array index too large");
        }
        //Return the array
        return temp;
    }
}