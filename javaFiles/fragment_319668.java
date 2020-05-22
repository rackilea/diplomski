System.out.println("Enter month:");
while (true) {
    try {
        int min = sc.nextInt();
        break;
    } catch (InputMismatchException ex) {
        System.err.println("Invalid input, please enter again");
        sc.nextLine();  //  <----- advance the scanner
    }
}