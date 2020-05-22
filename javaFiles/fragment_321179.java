ArrayList<ProductMaster> list=new ArrayList<ProductMaster>();
    System.out.println(choice);
try{
        if(choice.toLowerCase().equals("yes"))
        {
        System.out.println("You entered yes, Now please enter number of new items");
        n=Integer.parseInt(br.readLine());

        System.out.println("You have chosed to enter items"+n);

        for(int i=0;i<n;i++)
            {
               System.out.println("Enter the item name:");
               String n1=br.readLine();
              System.out.println("Entered:"+n1);
               System.out.println("Enter the item price:");
                Double n2=Double.parseDouble(br.readLine());
                System.out.println("Entered:"+n2);
               System.out.println("Enter the item sale quantity");
               n3 =Integer.parseInt(br.readLine());
               System.out.println("Entered:"+n3);
               System.out.println("Enter the item sale price");
               Double n4=Double.parseDouble(br.readLine());
               System.out.println("Entered:"+n4);

             ProductMaster newC= new ProductMaster(n1,n2,n3,n4);
             list.add(newC);
            }