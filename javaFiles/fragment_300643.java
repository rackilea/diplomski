class MyThread extends Thread{
   private boolean interrupted=false;


   public void interruptMyThread(){
       interrupted=true;
   }

   public void run(){
       while(true){
           // ... some work the thread does

           // ... a point in the thread where it's safe
           // to stop...
           if(interrupted){
               break;
           }
       }
   }
}