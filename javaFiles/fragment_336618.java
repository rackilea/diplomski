import java.util.Scanner;  

public class Average {  

    public static void main(String[]args) { //creating public static main
        double[] numbers = readInputNumbers();
        System.out.println("Average is: " + average(numbers));
        System.out.println("Max: " + max(numbers));
        System.out.println("Min: " + min(numbers));
    }

    public double[] readInputNumbers() {
      Scanner input = new Scanner(System.in); //creating scanner input to grab user input
      System.out.println("Please enter a list of numbers, entering -1 to end the list: ");
      double[] numbers = new double[20];
      final int endInput = -1;
      for(int i = 0; i < numbers.length; i++) {
          System.out.print("Enter a number: ");
          double nextNumber = input.nextDouble();
          if(nextNumber == endInput) {
              break;
          } else {
              numbers[i] = nextNumber;
          }
      }
      return numbers;   
  }

    public static double max(double[] array) {
        double maxNum = array[0];
        for(int i = 1; i<array.length; i++) {
            if(array[i] > maxNum) {
                maxNum = array[i];
            }
        }
     return maxNum; 
    }

    public static double min(double[] array) {
        double minNum = array[0];
        for(int i = 1; i<array.length; i++) {
               if(array[i] < minNum && array[i]!=-1) {
                minNum = array[i];
            }

        }
     return minNum; 
    }

    public static double average(double[] numbers) {
        double sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum / numbers.length; 
    }

}