@Component
public class TransactionTutorial {

    @Transactional
    public void aboutRequired() {
        //This method will create a new transaction if it is called with no active transaction 

        //Some logic that should be executed within a transaction

        //normal() method will also run under the newly created transaction.
        normal();

        //An exception will be thrown at this point
        //because aboutNever() is marked as Propagation.NEVER 
        aboutNever();
    }

    @Transactional(propagation=Propagation.NEVER)
    public void aboutNever() {
        //This method should be called without any active transaction.
        //If it is called under active transaction, exception will occur.

        //Some logic that should be executed without a transaction.
    }

    public void normal() {
        //This method is not bothered about surrounding transaction.
        //You can call this method with or without an active transaction.

        //Some logic
    }
}