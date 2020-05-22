public static void main(String[] args) {
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setLocationRelativeTo(null);

    final JProgressBar jProgressBar = new JProgressBar();
    final JLabel status = new JLabel("Connecting...");
    frame.add(status);
    frame.add("jProgressBar", jProgressBar);

    frame.pack();
    frame.setVisible(true);

    SwingWorker sw = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            jProgressBar.setIndeterminate(true);
            Thread.sleep(6000); // Here you should establish connection
            return null;
        }

        @Override
        public void done(){
            jProgressBar.setIndeterminate(false);
            status.setText("Successful");
            jProgressBar.setValue(100); // 100%
        }
    };
     sw.execute();        
}