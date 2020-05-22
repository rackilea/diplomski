import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;

public class Reader{

    public static void main(String args[]) throws IOException{

        File inFile;
        FileReader fr;
        BufferedReader bufReader;
        JFileChooser chooser;

        int reply;

        try{

            chooser = new JFileChooser();
            reply = chooser.showOpenDialog(null);
            // Read all the lines in the file at once
            List<String> lines = Files.readAllLines(Paths.get(chooser.getSelectedFile().getAbsolutePath()), StandardCharsets.UTF_8);

            // Merge the read lines into a String
            StringBuilder sb = new StringBuilder();
            for (String line : lines){
                sb.append(line);
                sb.append('\n');
            }

            String newLine = sb.toString();

            // Split the String
            String arr[] = newLine.split("\\*TEXT");
            System.out.println(java.util.Arrays.toString(arr));

        }//end try
        catch(Exception e)
        {   System.out.println("error: "+e.getMessage());   }

    }//main
}//end class reader