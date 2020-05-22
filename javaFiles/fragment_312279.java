import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {

private List<Integer> data = new ArrayList<Integer>(); //Create ArrayList

public static void main(String[] args) {
    String filename = "C:/input.txt";

    File rfe = new File();
    rfe.readFile(filename);
}

private void readFile(String name) {
    String input;

    try (BufferedReader reader = new BufferedReader(new FileReader(name))) {

        while((input = reader.readLine()) != null) {
            data.add(Integer.parseInt(input));//Add each parsed number to the arraylist
            System.out.println(input); // Display the line on the monitor
        }
    }
    catch(FileNotFoundException fnfe) {

    }
    catch(IOException ioe) {

    }
    catch(Exception ex) { // Not required, but a good practice
        ex.printstacktrace(); //Usually good for general handling
    }

}
}