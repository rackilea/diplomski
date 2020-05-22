public static int readIntoArray(Scanner input, int[] nums) {

    int count = 0; // Will hold the number of values in array

    while(input.hasNextInt() && count < 100) {
        nums[count] = input.NextInt();
        count++;
    }

    return count;
}