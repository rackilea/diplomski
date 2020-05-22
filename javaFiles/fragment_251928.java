public class NextLevelCounter {
    JWindow window = new JWindow();

    public static void main(String[] args) {
        new NextLevelCounter();
    }

    public NextLevelCounter() {
        window.getContentPane().add(new JLabel("Waiting"));
        window.setBounds(0, 0, 300, 200);
        window.setVisible(true);

        //Create a worker that whill close itself after 5 seconds. The main thread
        //is notified and will dispose itself when worker finishes
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
           @Override
           protected Void doInBackground() throws Exception {
                 Thread.sleep(5000);
                 return null;
           }

           protected void done() {
               window.dispose();
           }
      };

      worker.execute();
    }
}