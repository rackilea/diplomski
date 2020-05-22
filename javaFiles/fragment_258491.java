//initialization phase
    double stop = 1;
    double totalMiles = 0;
    double totalGallons = 0;

   // if the user enters zero it will stop the loop
   while (stop != 0)
   {  
       System.out.print("Enter a number for miles traveled, or enter 0 to exit: ");
       double newMiles = input.nextInt();

       if (newMiles == 0)
       {
           //took me a while to figure out where th break goes and {} placement
           break;
       }
       else
       {
           System.out.print("Enter number of gallons used: ");
           double newGallons = input.nextInt();

           // i have tried multiple different ways to get totalMPG wont work
           totalMiles += newMiles;
           totalGallons += newGallons;

           System.out.println("Your average MPG is " + (newMiles/newGallons));
       }
  }

   System.out.println("Your total trip MPG is " + (totalMiles/totalGallons));
}