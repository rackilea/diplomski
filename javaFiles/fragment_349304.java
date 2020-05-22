//given you an open scanner
    boolean isCorrectPrice = false;

    System.out.println("enter price");
    price = in.nextDouble();
    while(!isCorrectPrice)
    {
       if(price%0.25==0 && price<=1.25 && price>0)
       {
          System.out.println("you entered "+price);
          IsCorrectPrice = true;
          continue;
       }
       System.out.println("incorrect price, re-enter ");
       price = in.nextDouble();
    }
   //your code after user enters correct price