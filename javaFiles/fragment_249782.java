public boolean connect(){ 
   int maxAttempt = 3;
   for(int cons_attempts  = 0 ; cons_attempts   < maxAttempt  ; cons_attempts  ++){ 
     if (_connect()) {return true;}
     try 
      {
         Thread.sleep(3000);
      } 
       catch (InterruptedException ex){}
     }
   }
   return false;
 }