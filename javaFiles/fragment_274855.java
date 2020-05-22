while(!Thread.currentThread().isInterrupted()){  
   //do something   
   try{  
     Thread.sleep(5000);    
   } catch(InterruptedException e){  
        Thread.currentThread().interrupt();
   }
}