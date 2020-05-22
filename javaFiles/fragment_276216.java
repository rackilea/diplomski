import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AreaOfCircle {
    private static double PI = Math.PI;
    private double radius;
    private static double area;
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        AreaOfCircle a = new AreaOfCircle();
        System.out.print("Type in the radius of circle: ");
        a.radius = keyboard.nextDouble();
        getArea(a.radius);
        System.out.print("Name of the txt file you want to create:");
        String fileName = keyboard.next();
        keyboard.nextLine();
        try {
            File myFile = new File(fileName);
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            FileWriter fw = new FileWriter(myFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("The area of the circle is " + area + ".\n");
            bw.close();
        }
        catch (IOException e) {
            System.out.println("IOException Occured");
            e.printStackTrace();
        }
    }

    public static void getArea(double n) {
        area = n * PI;
    }
}