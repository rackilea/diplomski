while (((coordinates[0]<0)||(coordinates[0]>R))  && check) {
    System.out.print("Please enter a valid row number:\t");
    try { 
        coordinates[0]=scanner.nextInt(); 
    }
    catch (InputMismatchException e) {
        System.out.println("That's not a valid number.");
        scanner.nextLine();
    }
}