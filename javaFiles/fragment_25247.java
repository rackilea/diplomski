if (number>0)
{
    for (count=1; count<=number; count++)
    {
        factorial = factorial*count;
        System.out.print(count);
        if(count < number)
            System.out.print(" * ");
    }

    System.out.println("Factorial of your number is "+factorial);
    System.out.println();
}