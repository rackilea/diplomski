int n = userInputScanner.nextInt();
while(n != 0)
{
    System.out.print("Enter Data: ");
    String date = userInputScanner.nextLine();
    if (date.length() == 0) continue; // <-- retry.