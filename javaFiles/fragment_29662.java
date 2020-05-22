import java.util.Scanner;

public class TestStuff {

    public static void main(String[] args) {
        //Keyboard Initialization
        Scanner kbin = new Scanner(System.in);

        //a.Declare an array to hold 10 intgers values
        int list[] = new int[10];
        int i = 0;

        System.out.print("\n\tInput numbers from 10 to 50: \n");
        while (i < 10) {
            //b.Fill the array with intgers from the keyboard(range: 10 to 50).
            int value = kbin.nextInt();
            if (value >= 10 && value <= 50) {
                list[i] = value;
                i++;
            } else {
                System.out.println("!! Bad number !!");
            }
        }
        for (int value : list) {
            System.out.println("..." + value);
        }
    }
}