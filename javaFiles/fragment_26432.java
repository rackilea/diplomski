//...in some concrete implementation of SwingWorker<Void, Integer>
protected Void doInBackground() throws Exception {
    //do 10% of task
    doLongOp();
    publish(10);

    //do another 20% of task
    doAnotherLongOp();
    publish(20);

    return null;
}

protected void process(List<Integer> pieces) {
    for (Integer percent : pieces ) {
       progressBar.setValue(progressBar.getValue() + percent);
    }
}