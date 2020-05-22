class Worker extends SwingWorker<Void, String> {

    @Override
    protected void doInBackground() throws Exception {
       //here you make heavy task this is running in another thread not in EDT
       //process after some time call publish() 


    }

    @Override
    protected void process(List<String> chunks) {
        //this is executed in the EDT
        //here you update your label
    }
}