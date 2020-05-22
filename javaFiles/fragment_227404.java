Calendar pd = null;
while (pd == null) {
    System.out.print("Enter Date (DD MM YYYY): ");
    input.nextLine();
    String pickUpDate = input.nextLine();
    pd = stringToCalendarConverter(pickUpDate);
}