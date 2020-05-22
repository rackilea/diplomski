package circle;
import java.util.Scanner;
public class Circle {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int radius=0;
    float diameter;
    double circumference ;
    double area;
    double Pi;

    Pi= 3.14;



    System.out.print("Enter radius value:");
    radius=input.nextInt();

    area = (radius*radius*Pi);
    circumference =(radius*2*Pi);
    diameter = (radius*2);

    System.out.printf("area is " + area);
    System.out.printf("\ndiameter is "+ diameter);
    System.out.printf("\ncircumference is "+ circumference);
} 
}