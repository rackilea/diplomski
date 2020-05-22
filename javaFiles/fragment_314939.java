public static void main(String[] args) {
    int[] circularlySortedArray = { 0, 1, 2, 3, -1, -2, -3 };

    // define a variable for the sum of positive values
    int sumOfPositives = 0;
    // define a variable for the lowest index of a positive number
    int firstPositiveIndex = -1;
    // define a variable for the lowest positive number found
    int smallesPositiveNumber = 0;

    // start iterating the array
    for (int i = 0; i < circularlySortedArray.length; i++) {
        System.out.println("Current index: " + i 
                + ", current value: " + circularlySortedArray[i]);
        // provide a variable for the current number to make this code a little more
        // readable
        int number = circularlySortedArray[i];

        // check if the current number is positive
        if (number >= 0) {
            // add it to the sum
            sumOfPositives += number;
            System.out.println("Added " + number 
                    + " to sumOfPositives (now: " + sumOfPositives + ")");
            // check if it is the first positive number found
            if (firstPositiveIndex < 0) {
                // if yes, set the variable value accordingly
                System.out.println("First and smallest positive number (" 
                                    + number 
                                    + ") found at index " 
                                    + i);
                firstPositiveIndex = i;
                smallesPositiveNumber = number;
            }
            System.out.println("————————————————————————————————");
        } else {
            // break conditions based on index & value of the smallest positive number found
            if (i > firstPositiveIndex && firstPositiveIndex > 0) {
                System.out.println("Stopped the loop at index " + i);
                break;
            } else if (smallesPositiveNumber == 0 && firstPositiveIndex == 0) {
                System.out.println("Stopped the loop at index " + i);
                break;
            }
            System.out.println(number + " is not positive, skip it");
            System.out.println("————————————————————————————————");
            continue;
        }
    }

    System.out.println("The sum of positive numbers is " + sumOfPositives);
}