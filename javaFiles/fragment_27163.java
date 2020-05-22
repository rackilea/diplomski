class Worker extends SwingWorker<Void, String> {
    private SomeClass businessDelegate;    
    private JLabel label;

    @Override
    protected Void doInBackground() throws Exception {
       //here you make heavy task this is running in another thread not in EDT
        businessDelegate.callSomeService();
        setProgress(30); // this is if you want to use with a progressBar
        businessDelegate.saveToSomeDataBase();
        publish("Processes where saved");
        return null;
    }

    @Override
    protected void process(List<String> chunks){
       //this is executed in EDT you can update a label for example
       label.setText(chunks.toString());
    }

   //add setters for label and businessDelegate    
}