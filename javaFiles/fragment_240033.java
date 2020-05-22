public static void mathsChoice() throws IOException{
        System.out.println("'1' for Addition, '2' for Subtraction, '3' for Division");
        int resChoice = scanner.nextInt();
        if (resChoice == 1){
            additionMethod();
        }else if (resChoice == 2){
            subtractionMethod();
        }   else if (resChoice == 3){
            divisionMethod();
        }else {
              throw new IOException("Not valid, try again.");
        }
     mathsChoice();

}