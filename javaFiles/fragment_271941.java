public RequestProcessor(CountDownLatch cdl, Customer customer , int threadSeq ) {
        super();
        this.customer = customer;
        this.threadSeq = threadSeq;
        this.cdl=cdl;                                            // new code 
        }
    @Override
    public void run() {
        // TODO Auto-generated method stub
       processRequest();
       super.run();
       cdl.countDown();                                          // new code 
    }