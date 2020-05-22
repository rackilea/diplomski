while ( x >= 0 )
{
    System.out.println("Enter next value"); 
    x = arr.nextInt();

    if(x >= 0) //Add this if block
    {
        a[size]=x;
        size++;         
    }
}