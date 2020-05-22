public static int inputInt(String message) {                                            
    int returnval = 0;
    System.out.println(message);
    while(!sc.hasNextInt()) {
        sc.nextLine();
        System.out.println("You must enter an integer.");
    }
    returnval = sc.nextInt();
    return returnval;
}