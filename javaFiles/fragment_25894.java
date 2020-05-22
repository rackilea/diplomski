while (invoice < 1000 || invoice > 8000)
{
  System.out.println("You entered an invalid number.");
  System.out.println("Please enter a number between 1000 and 8000.");
  invoice = input.nextInt();
}