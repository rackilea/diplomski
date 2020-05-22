import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BigFileSorter {

    public static final int NUM_LINES = 15000;
    public static final int NUM_FILES = 20;
    public static void main(String args[]) throws IOException {

        FileReader fileReader = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fileReader);

        ArrayList<ArrayList<String>> list = readingfile(br);
        makingfiles(br, list);

    }

    public static void makingfiles(BufferedReader br, ArrayList<ArrayList<String>> list) throws IOException {
        if (list != null) {
            for (int i = 0; i < NUM_FILES; i++) {
                File file = new File("Filee" + i + ".txt");
                FileWriter fw = new FileWriter(file);
                ArrayList<String> subList = list.get(i);
                for (String str : subList) {
                    fw.write(str + System.lineSeparator());
                }
                fw.close();
            }
        }
    }

    public static ArrayList<ArrayList<String>> readingfile(BufferedReader br)
            throws FileNotFoundException, IOException {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<String> subList;
        String line;
        try {
            for (int i = 0; i < NUM_FILES; i++) {
                subList = new ArrayList<String>();
                for (int j = 0; j < NUM_LINES; j++) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    subList.add(line);
                }
                Collections.sort(subList);
                list.add(subList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return list;
    }
}