//Here we will prompt the user to enter the amount of quarters
int quarters = 0;
System.out.println("How many quarters would you like to display? Please pick a number greater than zero and less than or equal to 10");
do
{
quarters = keyboard.nextInt();
if (quarters <= 0 || quarters >= 10)
{
System.out.println("You entered a number outside of the boundrys. Please Type a number greater than 0 and less than equal to 10 again)");
}
}
while (quarters <= 0 || quarters >= 10)