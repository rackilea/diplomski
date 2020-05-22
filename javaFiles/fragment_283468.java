import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class WriteToFile {
public static void main(String[] args) throws FileNotFoundException {
    String fileName = generateFileName();
    addHash(fileName);
}

public static void addHash(String file) throws FileNotFoundException {
    PrintStream out = new PrintStream(new FileOutputStream(file));

    String outString = "#";
    for (int maxRun = 0; maxRun <= 1000; maxRun++) {
        for (int y = 0; y <= 10; y++) {
            for (int x = -1; x <= y; x++) {

                System.setOut(out);
                System.out.print(outString);
            }
            outString += "#";
            System.setOut(out);
            System.out.println("");

        }

        for (int y = 10; y >= 0; y--) {
            for (int x = 0; x <= y; x++) {
                System.out.print(outString);
            }
            outString = outString.substring(0, outString.length() - 1);
            System.out.println("");

        }
    }
}
//creating filename
public static String generateFileName() {
    int i = 0;
    String filename = "D:\\TempFile"; //it will be stored inside D drive,you can change drive value according to your need.
    File f = new File(filename);
    while (f.exists()) {
        i++;
        filename = "D:\\TempFile"; 
        filename += Integer.toString(i);
        f = new File(filename);
    }
    return filename;
}
}