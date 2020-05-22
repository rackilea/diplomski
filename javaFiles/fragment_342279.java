import java.util.*;

public class PlainOldMultiplier {

    private final int digits;

    public PlainOldMultiplier(int digits) {
        this.digits = digits;
    }

    public void printAllMultipliedNumbers(int multiplicationSteps) {

        // define the result
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(1);// multiply by 1 in first iteration

        // foreach multiplicationStep once multiply all existing stuff with [start;end[
        for (int multiplicationStepCount = 0; multiplicationStepCount < multiplicationSteps; multiplicationStepCount++) {
            numbers = multiplyEverything(numbers);
        }

        // output numbers to console
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    private Collection<Integer> multiplyEverything(Collection<Integer> numbersOfPreviousIteration) {
        Collection<Integer> result = new ArrayList<>();

        // define start and end by taking account "digits"
        int start = (int) Math.pow(10, digits-1);
        int end   = (int) Math.pow(10, digits);

        // foreach number within [start;end[ multiply existing stuff
        for (int number = start; number < end; number++) {

            for (Integer numberOfPreviousIteration : numbersOfPreviousIteration) {
                result.add(numberOfPreviousIteration * number);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new PlainOldMultiplier(1).printAllMultipliedNumbers(1); // outputs [1;9]
        new PlainOldMultiplier(2).printAllMultipliedNumbers(1); // outputs [10;99]
        new PlainOldMultiplier(1).printAllMultipliedNumbers(2); // outputs [1;9] & [2;18] & ... & [9;81]
    }
}