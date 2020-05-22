System.out.println("Would you like a Diamond instead of a Pyramid? Type Yes or No");        
String input2 = scan.nextLine();
boolean d = input2.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No"); // confirms if the user input is Yes/No or invalid other than that
.... 
while (!d) { // d==false ' invalid user input
    System.out.println("Invalid Input. Please try again");
    input2 = scan.nextLine();
    d = input2.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No");
    System.out.println(d); 
    // also printing a boolean would print either true or false base on your input; you migt want to perform some other action
} // this would exit on user input "Yes"