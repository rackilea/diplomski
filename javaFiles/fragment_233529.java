public boolean processSave(){
   boolean success = true;
   try{
      //persistence operation via service class
   }
   catch(OptimisticLockException e){
      success = false;
      //add a faces message
   }
   catch(EJBTransactionRolledbackException e){
      success = false;
      //add another faces message
   }
   return success;
}