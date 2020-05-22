int size = 100; // Set the number of numbers to input.
int[] list = new int[size]; // Create an array with 'size' elements.
int min = Integer.MAX_VALUE; // Set the highest possible integer as start value.
int max = 0; // Set the minimum to zero, assuming that the user won't input negative numbers.
int sum = 0; // Initialize the sum of the numbers in the list.

Scanner scan = new Scanner(System.in);

for (int i = 0; i < size; i++) { // Run 'size' times the process of inputting a number.
    System.out.print("Enter number (0 to exit) " + (i + 1) + ": ");
    int number = scan.nextInt();
    if (number == 0) { // Quit program if input equals '0'
        System.out.println("Exiting...");
        break;
    }
    list[i] = number; // Add the current number to the list
    sum += number; // Add the number to the total
    if (number < min) { // If the number is smaller than the previous one, set this number as the smallest
        min = number;
    }
    if (number > max) { // If the number is greater than the previous smallest number, set this number as the greatest
        max = number;
    }
}

// Output all numbers in the list
for (int i = 0; i < list.length; i++) {
    if (list[i] != 0) {
        System.out.print((i == 0 ? "" : ", ") + list[i]);
    }
}

// You see the snippet (i == 0 ? "" : ", ")
// That is a shorthand if-else statement:
// If i equals 0, then "" (empty string), else ", " (comma and space).
// The statement
//     System.out.print((i == 0 ? "" : ", ") + list[i])
// is the same as
//     if (i == 0) {
//         System.out.println("") + list[i];
//     }
//     else {
//         System.out.println(", ") + list[i];
//     }

System.out.println("Smallest number is: " + min);
System.out.println("Largest numeber is: " + max);
System.out.println("Sum is: " + sum);