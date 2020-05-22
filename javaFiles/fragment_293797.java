protected Object doInBackground() throws Exception      
{          
   //do part 1 of long running task
   if(Thread.currentThread().isInterrupted()){
     //clean up and return
   }
   //do part 2 of long running task
   if(Thread.currentThread().isInterrupted()){
     //clean up and return
   }
   //etc..
}