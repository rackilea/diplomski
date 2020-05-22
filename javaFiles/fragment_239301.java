import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class NewMain {
    public static void main(String[] args) throws IOException{
        // Use file dialog to select file.
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        // This assumes user pressed Open
        // Get the file from the file 
        File file = chooser.getSelectedFile();
        // Open the file
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
        String line = reader.readLine();
        while (line != null){
            System.out.print(line);
            if (line.contains("ZONK")){
                System.out.println("    // corrupted code");
            }else{
                System.out.println("");
            }
            line = reader.readLine();
        }
        reader.close();
    }
}