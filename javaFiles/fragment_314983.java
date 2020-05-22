import java.io.File;
import java.util.Scanner;

public class ReadFile {


    public static void main(String[] args) {

        try {

            File file = new File("/home/fotis/Documents/Mailers.txt"); //this a the path there
            try (Scanner input = new Scanner(file).useDelimiter("\\t")) {
                String line[] = new String[150000];
                int i=0;


                while (input.hasNextLine()) {
                    line[i] = input.next();
                    System.out.println(line[i]);
                    i++;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }