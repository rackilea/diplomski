public class SumOfNumbers {
    public static void main(String[] args) {

        int[] intArgs = new int[args.length];
        for (int x = 0; x < args.length; x++) {
            if (args[x].matches("\\d+")) {
                intArgs[x] = Integer.parseInt(args[x]);
            } else {
                System.out.println(args[x] + " is not a Integer hence skiped in this program");
            }
        }

        // Printing the entered digits
        System.out.print("Passing");
        System.out.print(" [ ");

        for (int nums = 0; nums < intArgs.length; nums++) {
            System.out.print(intArgs[nums] + " ");

        }
        System.out.print("] ");
        System.out.println("\nSum is " + returnSum(intArgs)); // Calling on the second method for the sum

    }

    // Taking the nums from the main method as arguments
    public static int returnSum(int... args) {
        int sum = 0;
        // Calculating the sum
        for (int nums = 0; nums < args.length; nums++) {
            sum = sum + args[nums];
        }
        return sum;
    }
}