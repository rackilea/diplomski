if (number>0)
{
    for (count=number; count>1; count--)
    {
        factorial = factorial*count;
        System.out.print(count);
        if(count > 2)
            System.out.print(" * ");
    }

    System.out.println("Factorial of your number is "+factorial);
    System.out.println();
}