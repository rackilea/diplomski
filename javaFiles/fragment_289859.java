public class Example_R {
public static void main(String args[]) {
    int input[] = { 1, 2, 1, 3, 4 };
    int largestSum = 0;
    int currentSum;

    for (int j = 0; j < input.length; j++) {
        currentSum = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[j] != input[i]) {
                currentSum += input[i];
            }
        }
        System.out.println("Sum of all values not equal to " + input[j]
                + " is: " + currentSum);
        if (j == 0) {
            largestSum = currentSum;
        } else {
            if (largestSum < currentSum) {
                largestSum = currentSum;
            }
        }
    }
    System.out.println("The largest overall sum was " + largestSum);
}
}