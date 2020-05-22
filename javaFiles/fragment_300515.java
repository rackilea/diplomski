class PingWorker extends SwingWorker<Void, PingResult> {
    private List<IpAddress> addresses;

    public PingWorker(List<IpAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (IpAddress address : addresses) {
            // run ping code and build result
            publish(new PingResult(address /* other result params here */));
        }

        // no need to return anything as we are processing the intermediate results
        return null;
    }

    @Override
    protected void done() {
        // pings are complete, update GUI to reflect this
    }

     @Override
     protected void process(List<PingResult> results) {
         for (PingResult result : results) {
             // update GUI with the result of the ping such as your table model
         }
     }
}