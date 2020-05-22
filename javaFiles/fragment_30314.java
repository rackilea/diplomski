System.out.print("Enter an integer: ");
int number = in.nextInt();   //Waits for user input
System.out.println(number);
while(in.hasNextInt())       //Waits for another user input
{
   System.out.print("Enter an integer: ");
   number = in.nextInt();
   System.out.println(number);
}