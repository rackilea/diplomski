import java.util.Scanner;

public class AreaInv2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi there! What's your name?");
        String name = sc.next();
        String yesno;
        do {
            System.out.println("Alright , " + name + ", enter the radius of the circle:");
            float radius = sc.nextFloat();   
            float area = (float) (Math.pow(radius, 2) * Math.PI);

            System.out.print("The area is ");
            System.out.printf("%.2f", area);
            System.out.println(". Would you like the area of any other circles?");
            yesno = sc.next();

            while ((!(yesno.equalsIgnoreCase("yes") || yesno.equalsIgnoreCase("no")))) {
                System.out.println("Sorry, could you say yes or no?");
                yesno = sc.next();
            }
        } while (yesno.equalsIgnoreCase("yes"));

        System.out.print("Have a great day " + name + "!");
        sc.close();                
    }
}