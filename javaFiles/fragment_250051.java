Scanner keyboard = new Scanner(System.in);
int num1, num2;
String input;
input = new String();
char again = 'y'; // You need to initialize it to y or Y so it can enter into while loop
while (again == 'y' || again == 'Y') {
    System.out.print("enter a number:");
    num1 = keyboard.nextInt();
    System.out.print("enter another number:");
    num2 = keyboard.nextInt();
    System.out.println("their sum is " + (num1 + num2));
    System.out.println("do you want to do this again?");
    again = keyboard.next().charAt(0); // You need to take the input from user and assign it to again variable which will get checked in while loop condition
}
System.out.println("Program ends");