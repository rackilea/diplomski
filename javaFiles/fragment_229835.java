import java.util.Scanner;
import java.io.File;

public class StartUpFile {

private String fileText;

/**
 * Constructor for objects of class StartUpFile
 */
public StartUpFile(String fileName) {
    readFile(fileName);
}

/**
 * Loads the text file into the class\object
 */
public void readFile(String fileName) {
    fileText = "";
    try {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            fileText += line + "\n";
        }
        file.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}

public String showFile() {
    return fileText;
}

public void modifyFile(String fileName) {
    fileText = fileName.replaceAll("Q", "z");
}

public static void main(String[] args) {
        StartUpFile startup = new StartUpFile("1.startup");
        StartUpFile startupModified = new StartUpFile("1.startup");

        System.out.println(startup.showFile());

        startupModified.modifyFile(startupModified.showFile());
        System.out.println(startupModified.showFile());
    }