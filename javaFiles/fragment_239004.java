import java.util.Random;

public class CompSci {
  public static void main(String[] args) {
    Random generator = new Random();

    int numbers[] = new int[100];     // not even really needed for this exercise
    int largest = Integer.MIN_VALUE;  // a very small number

    for (int x = 1; x < 100; x++) {
        int num1 = generator.nextInt(100);
        System.out.println ("A number from 1 to 100: " +num1);

        numbers [x] = num1;
        if(numbers[x] > largest)
        {
            largest = numbers[x]; //Set if find new largest number
        }
         System.out.println("Largest Number is: " + largest);
    }
}