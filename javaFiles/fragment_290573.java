Scanner in = new Scanner(System.in);        

    int x=0;

    System.out.println("Enter number: ");
    x = in.nextInt();

    for(int i=1;i<=x;i++){

        for(int j=1;j<=i;j++){
           System.out.print(" ");   
        }

        if(i%2==1)
        {
           System.out.println("*");
        }else
        {
           System.out.println("#"); 
        }
    }