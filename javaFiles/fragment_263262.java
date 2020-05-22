import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Average
   {

        public void printAverage(){
            File file = new File(""J:\\AP Comptuter Science\\Semester 2\\Exeptions\\13.1\\numbers.txt"");
            Scanner scan;

            try {
                scan = new Scanner(file);
                int total = 0, counter = 0;

                while(scan.hasNextInt()){
                    System.out.println("loop");
                    total = total + scan.nextInt();
                    counter++;

                }
                if(counter != 0)
                    total = total/counter;
                System.out.println(total);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

   }