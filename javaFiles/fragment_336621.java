public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    int num = 0; // to store user's enter
    int odd = 0, count = 0, even = 0; // to store all counts

    System.out.print("Enter any number to continue. Enter 0 to stop.");
    // ask for first number
    num = x.nextInt();

    // loop until 0 is entered
    while (num != 0) {
        // each time sum 1 because new number entered
        count ++;
        // if num / 2 modulus is 0 then even number 
        if (num % 2 == 0) {
            even ++;
        // if num / 2 modulus is not 0 then odd number 
        } else {
            odd ++;
        }

        // ask for a new number
        num = x.nextInt();
    }

    // print the results
    System.out.printf("You entered %d numbers\n",count);
    System.out.printf("You entered %d even numbers\n",even);
    System.out.printf("You entered %d odd numbers\n",odd);
}