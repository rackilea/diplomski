import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCountstackquestion implements Runnable {

    public String filename;

    public WordCountstackquestion(String filename) {
        this.filename = filename;
    }

    public void run() {
        File dir = new File(filename);

        if (dir.exists() && dir.isDirectory()) {
            Scanner in = null;

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for (File file : dir.listFiles()) {
                if (file.exists() && !file.isDirectory()) {
                    int count = 0;
                    try {
                        in = new Scanner(file);
                        while (in.hasNextLine()) {
                            String line = in.nextLine();
                            String[] words = line.split(" ");

                            for (String w : words) {
                                if (map.containsKey(w)) {
                                    map.put(w, map.get(w) + 1);
                                } else {
                                    map.put(w, 1);
                                }
                            }
                            count++;

                        }

                        //System.out.println(file + " : " + count);
                    } catch (FileNotFoundException e) {
                        System.out.println(file + " was not found.");
                    } finally {
                        if (in != null) {
                            in.close();
                        }
                    }
                }
            }

            for (String word : map.keySet()) {
                System.out.println(word + " " + map.get(word));
            }
        }
    }
}