public static void main(String[] arguments) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    final JProgressBar bar = new JProgressBar(0, 100);

    Thread t = new Thread(){
        public void run(){
            for(int i = 0 ; i < 100 ; i++){
                final int percent = i;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        bar.setValue(percent);
                    }
                  });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        }
    };
    frame.add(bar);
    frame.pack();
    frame.setVisible(true);
    t.start();
}