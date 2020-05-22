import java.util.Scanner;

public class MinMaxForLoop {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double current;

        System.out.println("Enter 10 double values:");
        for (int i = 0; i < 10; i++) {
            System.out.print((i+1) + ". -> ");
            current = input.nextDouble();
            if(current < min)
                min = current;
            else if(current > max)
                max = current;
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

}