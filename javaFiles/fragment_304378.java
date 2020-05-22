import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // Location of file to read
        File file = new File("data.rtf");
        String line="";
        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                //System.out.println(line);


            }


          String[] nameArray=line.split(","); 

          for(String s:nameArray){

         System.out.print(s+" "); //parse the array to verify entries

         }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}