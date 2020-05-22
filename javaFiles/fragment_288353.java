import java.io.*;
import java.lang.*;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        try {
                File file1 = new File("file");
                Scanner s1 = new Scanner(file1);
                System.out.println("using File: "+s1.hasNextLine());
                File file2 = new File("file");
                Scanner s2 = new Scanner(new FileInputStream(file2));
                System.out.println("using FileInputStream: "+s2.hasNextLine());
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}