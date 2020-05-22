class dragon extends monster{
      @Override // This tells the compiler to check the parent for this method you are going to override and if you've followed the right format
      boolean frighten(int degree){
           System.out.println("breath fire");
           return true;
      }
 }