package so36862093;

import com.google.common.io.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.*;

public class App {
    public static void main(final String[] args) throws Exception {
        final File file1 = new File(Resources.getResource("so36862093/ChineseWord.txt").toURI());
        final List<String> list = Files.readAllLines(file1.toPath());
        final File file2 = new File(Resources.getResource("so36862093/RandomData.txt").toURI());
        final Scanner newScanner = new Scanner(new FileInputStream(file2));
        final Map<String, Integer> count = new HashMap<>();

        while(newScanner.hasNext()){
            final String word = newScanner.nextLine();

            for (String toMatch : list) {
                if(word.contains(toMatch)){
                    System.out.println("Success");
                    count.put(toMatch, count.getOrDefault(toMatch, 0) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> e : count.entrySet()) {
            System.out.println(e.getKey() + " exists " + e.getValue() + " times.");
        }
    }
}