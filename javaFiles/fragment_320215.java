import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public static void main(String[] args) throws IOException {

    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    # get filename from user
    System.out.println("Enter a filename: ");
    String currName = buffer.readLine();

    # get altSep from user
    System.out.println("Enter a altSep: ");
    String altSep = buffer.readLine(); //reader.next();
    altSep = altSep.matches("[0-9a-zA-Z]") ? altSep : "\\" + altSep;

    # format regex with user input
    String regex = "(%s.*)(?=\\.\\w+)"; 
    regex = String.format(regex, altSep);        
    String newName = currName.replaceAll(regex, "");

    # the output
    System.out.println(newName);

}