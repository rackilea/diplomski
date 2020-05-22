double number1 = 0;
while(true) {
    System.out.print("First number: ");
    if (input.hasNextDouble()) {
        number1 = input.nextDouble(); // This will not throw an exception
        break;
    }
    System.out.print("This is not a number. ");
    input.nextLine();        
}