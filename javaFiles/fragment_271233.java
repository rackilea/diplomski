for (int month = 0; month < energyCons.length; month++) {
  System.out.print("Please enter the monthly kWh usage for month ");
  System.out.print((month + 1) + ": ");
  int inputValue = scan.nextInt();
  while (inputValue < 0 || inputValue > 1000) {
    System.out.println("Please enter a valid amount: ");
    inputValue = scan.nextInt();
  }
  energyCons[month] = inputValue;
}