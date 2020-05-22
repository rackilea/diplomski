package uploadTask7_countingSalaries;

//import utilities needed for the program
import java.util.Scanner;
import java.io.File;

public class countingSalaries {

    public static void main(String[] args) throws Exception { 
        List<Double> salaries = new ArrayList<Double>();
        // defines the file that data will be read from
        File salaryFile = new File("salaries.txt");
        // creates scanner object to read data from file
        Scanner scanFile = new Scanner (salaryFile);
        // creates while loop to read and print data to the user
        while(scanFile.hasNextDouble()) {
            double i = scanFile.nextDouble();
            salaries.add(i);
            System.out.println(i); }

       double total = 0;
       for(double a : salaries){
        total = total + a;
       }

        System.out.println("Total salary is: " + total);
        System.out.println("Avg = " + total/salaries.size();

        }
    }