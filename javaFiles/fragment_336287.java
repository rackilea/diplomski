int n = -1;//<-- it won't allow user to skip the loop after first pass without proper input
do {
    System.out.print("Please enter a positive integer: ");
    try {
        n = input.nextInt();//<-- in one pass ask input from user only once
        if(0 > n) {
            System.out.print("You have not entered a positive integer. \nPlease enter a positive integer: ");
        }
    } catch (NumberFormatException ex) {
        System.out.println("Invalid number !");
        break;//<-- break loop here, if don't wana prompt user for next input
    } catch(java.util.InputMismatchException ex) {
        System.out.println("Oops number is required !");
        break;//<-- break loop here, if don't wana prompt user for next input
    }
} while (n <= 0);