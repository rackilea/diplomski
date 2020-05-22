public void startCalculation() {

    Timer timer = new Timer(1000, new ActionListener() {

        AtomicInteger elapsedSeconds = new AtomicInteger();

        @Override
        public void actionPerformed(ActionEvent evt) {
            label.setText(String.format("Elapsed time: %d seconds", elapsedSeconds.incrementAndGet()));
       }
    });

    SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {

        @Override
        protected Integer doInBackground() throws Exception {
            // do heavy stuff
            Thread.sleep(3000); // it is safe to "sleep" here because it's not executed in the EDT
            return 1;
        }

        @Override
        protected void done() {
            timer.stop();
            // update the GUI with the results here if it's required
        }
    };

    timer.start();
    worker.execute();
}