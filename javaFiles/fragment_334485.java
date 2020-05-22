public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);      
    System.out.println("Enter an integer:");
    int firstNum = keyboard.nextInt();

    System.out.println("Enter another integer larger than the first one:");
    int secondNum = keyboard.nextInt();

    System.out.println();

    int mod = firstNum % 2;
    //If first number is odd, increase by one to make it even.
    if (mod != 0)
    {
        firstNum++;
    }

    System.out.print("Even Numbers: ");
    while (firstNum <= secondNum)
    {
        System.out.print(firstNum + " ");
        firstNum = firstNum + 2;
    }
    keyboard.close();
}