import java.util.Scanner;

public class Bmi {
public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.print("Enter weight: ");
     int weight = input.nextInt();
     System.out.print("Enter height: ");
     int height = input.nextInt();
     int bmi = weight /(height*height) * 703;
     System.out.println(bmi);
}
}