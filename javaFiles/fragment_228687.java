public static void evenSum(){
    //prompt the user to enter the amount of integers
    Scanner console = new Scanner(System.in);

    System.out.print("how many integers? ");
    int numbers = console.nextInt();

    int evenSum = 0;
    int evenMax = 0;

    //for loop for the number of times to ask user to input numbers
    for (int i = 0; i < numbers; i++) {
        //input new number
        System.out.print("next integer? ");
        int num = console.nextInt();

        //check to see if the number is even. if it is not even, 
        //we don't care about it at all and just go to the next one
        if (num % 2 == 0){
            //add it to the sum
            evenSum += num;

            //if it's larger than the maximum, set the new maximum
            if (num > evenMax) {
                evenMax = num;
            }
        }
    }
    System.out.println("even sum = " +evenSum);
    System.out.println("even max = " +evenMax);
}