boolean validInput = false;

while (!validInput) {
    try {
        System.out.print("Enter the encryption mask: ");
        output = keyboard.nextInt();
        validInput = true;
    }
    catch(Exception e) {
        keyboard.nextLine(); // swallow token!
        System.out.println("Please enter a number, mask must be numeric");
    }
}
return output;