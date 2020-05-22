import java.util.Scanner; 
import java.util.stream.*; 

public class Average {  

    public static void main(String[]args) { //creating public static main
        double[] numbers = readInputNumbers();
        DoubleSummaryStatistics statistics = DoubleStream.of(numbers).summaryStatistics();
        System.out.println("Average is: " + statistics.getAverage()));
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Min: " + statistics.getMin());
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
}