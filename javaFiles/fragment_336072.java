package maketestcfg_cm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MakeTestCfg_CM {

    public static void main(String[] args) {
        String suppliedDataFile = args[0];
        if (suppliedDataFile.isEmpty() || suppliedDataFile.equals("")) {
            return;
        }

        // Variable to hold the actual System line separator
        String ls = System.lineSeparator();
        // A html template used to write to files in a single write.
        // Note we use tags instead of variables. These tags are 
        // replaced when we write to whichever file. The tags are:
        // %c% = City | %l% = Link | %n% = Node Name | %g% = GIS
        String htmlTemplate = " <TABLE>" + ls + 
                              "   <TR><TD>City:</TD><TD><b>%c%</b></TD></TR>" + ls +
                              "   <TR><TD>Node Name:</TD><TD>%n%</TD></TR>" + ls + 
                              "   <TR><TD>GIS:</TD><TD>%g%</TD></TR>" + ls + 
                              "   <TR><TD>Link:</TD><TD>%l%</TD></TR>" + ls +
                              " </TABLE>" + ls + ls;

        try {
            // Prepare to read the data file.
            // Place each line in the data file into a ArrayList.
            List<String> list = new ArrayList<>();
            String line;
            int counter = 0;
            try (BufferedReader input = new BufferedReader(new FileReader(suppliedDataFile))) {
                while ((line = input.readLine()) != null) {
                    // Ignore lines that contain nothing and ignore
                    // the first line which is a CSV header line.
                    line = line.trim();
                    if (line.equals("") || counter == 0) {
                        counter++;
                        continue;
                    }
                    list.add(line);
                }
            }

            // Each data file line is now contained within a 
            // List interface named 'list'. Now we process
            // each line (List element):
            for (int i = 0; i < list.size(); i++) {
                // Parse the current line into a String Array
                String[] City_Link_NodeName_GIS = list.get(i).split(",");
                // Get the GIS & trim off leading/trailing spaces (if any).
                String gis = City_Link_NodeName_GIS[3].trim();
                // Create the file name
                String currentFileName = gis + ".txt";
                File file = new File(currentFileName);
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                // Append to file...
                try ( FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); 
                      BufferedWriter bw = new BufferedWriter(fw)) {
                      // Here we replace the tags in template 
                      // with proper values. Notice that all element
                      // data is trimmed of leading/trailing whitespace
                      // (just in case).
                      bw.write(htmlTemplate.
                            replace("%c%", City_Link_NodeName_GIS[0].trim()).
                            replace("%n%", City_Link_NodeName_GIS[2].trim()).
                            replace("%g%", City_Link_NodeName_GIS[3].trim()).
                            replace("%l%", City_Link_NodeName_GIS[1].trim()));
                }
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(MakeTestCfg_CM.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(MakeTestCfg_CM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}