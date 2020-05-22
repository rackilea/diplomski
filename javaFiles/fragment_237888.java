private void myButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
txtResult.setText("");
myButton.setText("Working ...");
myButton.setEnabled(false);
myButton.repaint();
System.out.println("Doing Action ...");
    SwingWorker worker = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            //Memory intensive code
        }

        @Override
        protected void done() {
            segmentButton.setText("Original Text");
            segmentButton.setEnabled(true);
            super.done(); //To change body of generated methods, choose Tools | Templates.
        }
    };
    worker.execute();
}