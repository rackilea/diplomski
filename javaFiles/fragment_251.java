int order;
    int price=0;
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter how many orders: ");
    order = Integer.parseInt(scan.nextLine());

     //Create an integer array to store the input

    int bakeorder[] = new int[order];
    //int originalbakeprice[] = new int[order];
    for(int i=0;i<order;i++)
    {
        System.out.print("Enter the order " + (i+1) + " : ");
            bakeorder[i] = Integer.parseInt(scan.nextLine());
             price +=bakeorder[i];
    }
            System.out.println(price);