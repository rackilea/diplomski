class werewolf extends monster{
      boolean frighten(int d){ // Method **from** the parent class
      //This is implicitly built into the subclass due to inheritance
           System.out.println("arrah");
           return false;
      }
 }