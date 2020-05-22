final int workerId = 123;
SwingWorker<String,Object> myWorker = new SwingWorker<String,Object> {
   @Override
   public String doInBackground() {
       ...
   }
   @Override
   protected void done() {
       ...
   }
   @Override
   public int hashCode() {
       return workerId;
   }
   @Override
   public boolean equals(Object other) {
       return other == this;
   }
}