import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryContents {

    public static void main(String[] args) throws IOException {

        File f = new File("c:\\temp\\"); // current directory
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter file ext:");

        final String fileExt = myObj.nextLine();  // Read user input
        System.out.println("file ext is: " + fileExt);   
        myObj.close();

        File[] files = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith("."  +fileExt);
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            System.out.println(file.getCanonicalPath());
        }
    }
}