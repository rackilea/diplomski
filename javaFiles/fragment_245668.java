Scanner input = new Scanner(System.in);
int number = 0;
boolean valid = false;
System.out.println("Enter number: ");
if (input.hasNextLine()) {
    if (input.hasNextInt()) {
        number = input.nextInt();
        if (number >= 1 && number <= 4) {
            valid = true;
            System.out.println("Valid choice:" + number);
        }
    }
    input.nextLine();
    if (!valid) {
        System.out.println("Invalid choice. Good-bye.");
        System.exit(0);
    }
}