Scanner in = new Scanner(System.in);
System.out.print("Enter a number: ");
int i;

while (true) {
    try {
        i = Integer.parseInt(in.nextLine());
        System.out.println("Your input is " + i);
        break;
    } catch (NumberFormatException exception) {
        System.out.println("Please enter a number:");
    }
}