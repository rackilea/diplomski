Scanner sc=new Scanner(System.in);       
    String s;
    while(true)  //have created infinite loop as you want to continuously take inputs,
    {
        System.out.println("Enter value:");
        s=sc.next();    
        if(s.equals("quit"))                  //if enterd value is "quit" than it comes out of loop ,termination condition to come out
        {
            break;
        }
        System.out.println(""+s); //to Print string
        System.out.println(""+s.length());  //to print Entered string's length


    }