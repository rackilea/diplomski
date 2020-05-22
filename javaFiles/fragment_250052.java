Scanner keyboard = new Scanner(System.in);
int num1, num2;
char again;
do { // the loop first executes without checking any condition and you don't need to worry about initializing "again" variable
    System.out.print("enter a number:");
    num1 = keyboard.nextInt();
    System.out.print("enter another number:");
    num2 = keyboard.nextInt();
    System.out.println("their sum is " + (num1 + num2));
    System.out.println("do you want to do this again?");
    again = keyboard.next().charAt(0); // here "again" variable is initialized and assigned the value anyway
} while (again == 'y' || again == 'Y'); // checks the condition and accordingly executes the while loop or quits
keyboard.close();
System.out.println("Program ends");