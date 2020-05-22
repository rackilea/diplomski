public class NewClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System. in );
        //Create an array of integers to store user input
        int[] userNumbers = new int[5];
        System.out.print("Enter " userNumbers.length + " numbers: ");
        //Goes into a loop, and sets each array index to the user inputted integer
        for (int i = 0; i < userNumbers.length; i++) {
            userNumbers[i] = input.nextInt();
        }

        System.out.println("Enter a number you would like to search for");
        boolean exists = false;
        int numToSearch = input.nextInt();
        //for each number in the user numbers array, check to see if that number matches the number to search. If so, set exists = true and break out of the loop to check no further.
        for (int num: userNumbers) {
            if (numToSearch == num) {
                exists = true;
                break;
            }
        }

        //if else to decide which output to show the user.
        if (exists) {
            System.out.println(numToSearch + " is in the list");
        } else {
            System.out.println(numToSearch + " is not in the list");
        }
    }
}