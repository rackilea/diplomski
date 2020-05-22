public static void main(String[] args)
{
// create objects
Username usernameGenerator = new Username();
OddEven oddeven = new OddEven();
Scanner inputReader = new Scanner(System.in);

// prompt for real name and print username
System.out.print("Name: ");
String fullName = inputReader.nextLine();
usernameGenerator.username(fullName);

// prompt for number
System.out.print("Give me a number: ");
// variable to store value
int userInteger = inputReader.nextInt();
oddeven.OddEven1(userInteger);
}