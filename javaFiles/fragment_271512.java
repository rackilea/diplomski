public static int getIntFromConsole()
{
    Scanner scanner = new Scanner(System.in)
    int value;

    while (true) {
      try
      {
          value = Integer.valueOf(scanner.nextLine());
          break;
      }
      catch (NumberFormatException e) 
      {
         System.out.println("ERROR: Invalid input! Please enter a whole number.");
      }
    }
    return value;
}