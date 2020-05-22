if (op.equals('a'))
{
    System.out.print("Enter Integer number : ");
    num=input.nextInt();

    for(int i=num ; i >=num-i ;i--)
    {
        if(num%2!=0)
            odd=odd+""+i;
        System.out.print("odd numbers are : "+odd );
    }
}