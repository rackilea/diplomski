System.out.println("Enter M/N and Q to quit:");    
while(true)
{
    a = s.nextLine();
    if(/*a is valid*/)
    {
        break;
    }
    else
    {
        System.out.println("Insert invalid input message here.  Enter M/N and Q to quit:");    
        a = s.nextLine();
    }
}