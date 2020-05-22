package tryouts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(
                "/usr/projects/tryouts/src/tryouts/test.txt"));
        String line = sc.nextLine();
        System.out.println(line);
        StringTokenizer lineTok = new StringTokenizer(line);
        while (lineTok.hasMoreTokens()) {
            System.out.println(lineTok.nextToken());
        }
        sc.close();
    }
}