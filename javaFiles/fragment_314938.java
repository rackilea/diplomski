public static void main(String[] args) {
    int[] circularlySortedArray = {-2, 0, 3, 4, 11, 13, -23, -15, -8};

    // define a variable for the sum
    int sumOfPositives = 0;

    // go through all numbers in the array (n numbers)
    for (int number : circularlySortedArray) {
        // check if the number is positive
        if (number >= 0) {
            // and add it to the sum variable
            sumOfPositives += number;
        }
    }

    // then print the result
    System.out.println("The sum of positive numbers is " + sumOfPositives);
}