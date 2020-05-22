public abstract Object doTransaction();

public abstract Object executeTransaction(some params){
for (int i = 0; i < NUM_RETRIES; i++) {
     pm.currentTransaction().begin();

     this.doTransaction();

     try {
         pm.currentTransaction().commit();
         break;

     } catch (JDOCanRetryException ex) {
         if (i == (NUM_RETRIES - 1)) { 
             throw ex;
         }
     }
 }
}