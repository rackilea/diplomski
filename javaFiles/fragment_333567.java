public static void main(String[] args) {
    // Create the frame on the event dispatching thread
    SwingUtilities.invokeLater(new Runnable() {
       @Override
        public void run() {
           new SwingDemo();
        }
    });
}