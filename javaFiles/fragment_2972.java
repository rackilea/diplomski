import java.util.*;

    public class CubeSum {

        public static void main (String args []) {

            Scanner scan = new Scanner(System.in);

            int integer1, integer2, cube1, cube2;
            System.out.print("integer1: ");

            integer1=scan.nextInt();
            cube1 = (int)Math.pow(integer1 ,3);
            System.out.print("integer2: ");

            integer2=scan.nextInt();
            cube2 = (int)Math.pow(integer2 ,3);
            System.out.println("the sum of these cubes is: " + (cube1 + cube2));

        }
    }