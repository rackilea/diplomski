System.out.print("Enter the number of cookies you'd like to make:");
int number = input.nextInt();

while(number<=0) //As long as number is zero or less, repeat prompting
{
    System.out.println("Please enter a valid number:");
    number = input.nextInt();    
}