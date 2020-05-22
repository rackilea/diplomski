for (i=0; i<20; i++)
{
    System.out.println("Enter a number");
    current = in.nextInt();

    if (current < smaller)
    {
        smaller = current;
    }

    if(current > bigger)
    {
        bigger = current;
    }
}