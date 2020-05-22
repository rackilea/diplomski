public class TestProgress {

    public static void main(String[] args) {
        new TestProgress();
    }

    public TestProgress() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                ProgressPane progressPane = new ProgressPane();
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(progressPane);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                progressPane.doWork();
            }
        });
    }

    public class ProgressPane extends JPanel {

        private JProgressBar progressBar;

        public ProgressPane() {

            setLayout(new GridBagLayout());
            progressBar = new JProgressBar();

            add(progressBar);

        }

        public void doWork() {

            Worker worker = new Worker();
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("progress".equals(evt.getPropertyName())) {
                        progressBar.setValue((Integer) evt.getNewValue());
                    }
                }
            });

            worker.execute();

        }
    }

    public class Worker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {

            for (int index = 0; index < 1000; index++) {
                int progress = Math.round(((float) index / 1000f) * 100f);
                setProgress(progress);

                Thread.sleep(10);
            }

            return null;
        }
    }
}