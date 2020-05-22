public static void main(String[] args)
{
    int number = 10;
    /* if you want user to input */
    Scanner get = new Scanner(System.in);
    number = get.nextInt(); // get the next integer user types :)
    getFactorial(number);
} 

public static int getFactorial(int number)
{
    int factor = 1;
    if (number == 1)
    {
        System.out.println("Returned 1");
    }
    else
    {
        factor = number * getFactorial(number - 1);
        System.out.println("Returned " + factor);
    }
    return factor;
}