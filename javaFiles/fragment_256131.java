public void retrieveDetailTransaction(final String noTrans){
    SwingWorker<List<TransactionDetail>, Void> worker = 
      new SwingWorker<List<TransactionDetail>, Void>() {

      public List<TransactionDetail> doInBackground() {
        List<TransactionDetail> listTransD = transDetailControl.select(noTrans);
        return listTransD;
      }

      public void done() {
        try {
           listTransDetail = get();

           transDetailModel.setListTransaction(listTransDetail);
           transactionDetailTable.setModel(transDetailModel);       

        } catch (InterruptedException ex) {
           ex.printStackTrace();
        } catch (ExecutionException ex) {
           ex.printStackTrace();
        }
      }
   };
   worker.execute();       
}