JLabel label = new JLabel();
JButton button = new JButton("Calculate answer");

// Add a click listener for the button
button.addActionListener((ActionEvent e) -> {

    // Defines MyWorker as a SwingWorker whose result type is String:
    class MyWorker extends SwingWorker<String,Void> {
        @Override
        public String doInBackground() throws Exception {
            // This method is called on a background thread.
            // You can do long work here without blocking the UI.
            // This is just an example:
            Thread.sleep(5000);
            return "Answer is 42";
        }

        @Override
        protected void done() {
            // This method is called on the Swing thread once the work is done
            String result;
            try {
                result = get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            label.setText(result); // will display "Answer is 42"
        }
    }

    // Start the worker
    new MyWorker().execute();
});