import java.util.Scanner;

import org.junit.runner.JUnitCore;

public class Utf {
    public static void main(String[] args) {
    /*
     * creates and reads from scanner
     */
    Scanner in = new Scanner(System.in);
    String filename = in.nextLine();

    /*
     * gets Tester class' name and stores it as a String
     */
    String className = Tester.class.getName();

    /*
     * if user input String matches Tester class' name then run tests
     * else File Not Found
     */
    if (filename.equals(className)) {
        JUnitCore.main(className);
    } else {
        System.out.println("File not Found");
    }
    /*
     * closes scanner
     */
    in.close();

}