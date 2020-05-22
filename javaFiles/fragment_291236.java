import java.util.Scanner;

    public class Distance {
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            double x1=0;
            double x2=0;
            double y1=0;
            double y2=0;
            double distance=0;

            System.out.println("Enter the value of x1 : ");
            x1=in.nextDouble();
            System.out.println("Enter the value of y1 : ");
            y1=in.nextDouble();
            System.out.println("Enter the value of x2 : ");
            x2=in.nextDouble();
            System.out.println("Enter the value of y2 : ");
            y2=in.nextDouble();

            distance=Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
            System.out.printf("The distance between given coordinates is : %.5f",distance);
        }
    }