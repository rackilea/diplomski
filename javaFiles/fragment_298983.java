while(true) {
   if(paused)
   {
       try {
           Thread.sleep(500); // half a second
           continue;
       } catch(InterruptedException e)
       {
       }
   }
}