import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SaveGame {

    public static void main(String[] args) {        
        saveGame("John", "2",  "0", "0", "2", "3","2","4","3","3");
        saveGame("Andy", "2",  "0", "0", "2", "3","2","4","3","3");
        saveGame("John", "4",  "0", "0", "2", "3","2","4","3","5");
    }

    public static void saveGame(String user, String compTime1, String compTime2, String compTime3, String compLevel,
            String tokenCollected, String flipperCollected, String firebootsCollected, String wingbootsCollected,
            String keysCollected) {
        String strToBeSaved = user + "," + compTime1 + "," + compTime2 + "," + compTime3 + "," + compLevel + ","
                + tokenCollected + "," + flipperCollected + "," + firebootsCollected + "," + wingbootsCollected + ","
                + keysCollected;
        List<String> list = new ArrayList<String>();
        String line;
        File file = new File("Game.txt");
        boolean userAlreadyExists = false;
        BufferedReader br;
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    list.add(line); // Add each line to the list                    
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println("File could not be read for processing");
            }           
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                if (line != null && user != null && line.toLowerCase().contains(user.toLowerCase())) {
                    userAlreadyExists = true;
                    list.set(i, strToBeSaved); // Replace the existing user data with the new data
                    break;
                }
            }           
        }

        FileWriter fw;
        try {
            if (userAlreadyExists)
                fw = new FileWriter(file); // Overwrite if the file already exists
            else
                fw = new FileWriter(file, true); // Open the file in append mode

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            if (userAlreadyExists) {
                for (String ln : list) {
                    pw.println(ln); // Rewrite all the lines in the list
                }
            } else {
                pw.println(strToBeSaved);
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Record not saved");
        }
    }
}