public static double promptNumber(Scanner scan){
    System.out.print("Please enter a number: ");
    if(scan.hasNextDouble())
       return scan.nextDouble();
    else {
       scan.nextLine(); 
       System.out.println("That is not a number");
       return promptNumber(scan);
    }
}