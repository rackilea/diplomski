double bill = 0.0;
System.out.print("Please enter the total amount of your bill > ");
bill = keysIn.nextDouble();
while (bill < 0) {
    System.out.print("Your bill amount is less then 0, try again > ");
    bill = keysIn.nextDouble();
}