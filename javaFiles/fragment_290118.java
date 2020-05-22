import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Fm {
    public static void main(String[] args) throws Exception {
        File x = new File("somefile.txt");
        ArrayList<String> fileLines = new ArrayList<String>();
        String userString = "bar";

        Scanner s = new Scanner(x);
        while(s.hasNextLine()) {
            String nextLine = s.nextLine();
            if(userString.equals(nextLine))
                nextLine = nextLine.toUpperCase();
            fileLines.add(nextLine);
        }

        for (String line : fileLines) {
            System.out.println("Do something with: " + line);
        }
    }
}


$ cat somefile.txt
foo
bar
baz


$ java Fm
Do something with: foo
Do something with: BAR
Do something with: baz