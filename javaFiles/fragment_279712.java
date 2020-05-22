public class MyTxCallback extends TransactionSynchronizationAdapter {

    public void afterCompletion(int status) {
        if (status==STATUS_ROLLED_BACK) {
            //logic here.
        }
    }

}