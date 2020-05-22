public void open(Combination opening){

   // If the combination is right open the lock
   // if it was already open no change
   if(opening.equals(unlock)){
     opcl = true;
   } 
   // no else, if combination was wrong 
   // leave the status as it was
}