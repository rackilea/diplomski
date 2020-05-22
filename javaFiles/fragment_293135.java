try (Scanner scanner = new Scanner(System.in)) {
   int choice;
   while (true) {
       System.out.print("Choice: ");
       if (!scanner.hasNextInt()) {
            scanner.nextLine();//read new line character
            System.err.println("Not a number !");
            continue; // read again
       }
       choice = scanner.nextInt(); //got numeric value
       if (1 != choice && 2 != choice) {
             System.err.println("Invalid choice! Type 1 or 2 and press ENTER key.");
             continue; //read again
       }
       break;//got desired value
   }
   System.out.printf("User Choice: %d%n", choice);
}