public class ProducerComsumer {

    public static void main(String[] args) {
        new ProducerComsumer();
    }

    public ProducerComsumer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBorder(new EmptyBorder(12, 12, 12, 12));

                JProgressBar progressBar = new JProgressBar();
                panel.add(progressBar);

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Producer producer = new Producer();
                producer.start();

                Consumer consumer = new Consumer(producer, progressBar);
                consumer.start();
            }
        });
    }

    public class Producer extends Thread {

        private volatile float progress;
        private volatile boolean done;

        public Producer() {
            setPriority(NORM_PRIORITY - 1);
            setDaemon(true);
        }

        public float getProgress() {
            return progress;
        }

        public boolean isDone() {
            return done;
        }

        @Override
        public void run() {
            done = false;
            for (int index = 0; index < Integer.MAX_VALUE; index++) {
                progress = (float) index / (float) Integer.MAX_VALUE;
            }
            done = true;
            System.out.println("All done...");
        }
    }

    public class Consumer extends Thread {

        private Producer producer;
        private JProgressBar progressBar;

        public Consumer(Producer producer, JProgressBar progressBar) {
            setDaemon(true);
            setPriority(NORM_PRIORITY - 1);
            this.producer = producer;
            this.progressBar = progressBar;
        }

        public JProgressBar getProgressBar() {
            return progressBar;
        }

        public Producer getProducer() {
            return producer;
        }

        @Override
        public void run() {
            while (!producer.isDone()) {
                updateProgress();
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerComsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            updateProgress();
        }

        protected void updateProgress() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int progress = Math.round(getProducer().getProgress() * 100f);
                    System.out.println("Update progress to " + progress);
                    getProgressBar().setValue(progress);
                }
            });
        }
    }
}