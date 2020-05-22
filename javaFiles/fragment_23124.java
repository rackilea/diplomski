public class SwingWorkerProgress {

    public static void main(String[] args) {
        new SwingWorkerProgress();
    }

    public SwingWorkerProgress() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JProgressBar pbProgress;
        private JButton start;

        public TestPane() {

            setBorder(new EmptyBorder(10, 10, 10, 10));
            pbProgress = new JProgressBar();
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(pbProgress, gbc);

            start = new JButton("Start");
            gbc.gridy++;
            add(start, gbc);

            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    start.setEnabled(false);
                    ProgressWorker pw = new ProgressWorker();
                    pw.addPropertyChangeListener(new PropertyChangeListener() {

                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            String name = evt.getPropertyName();
                            if (name.equals("progress")) {
                                int progress = (int) evt.getNewValue();
                                pbProgress.setValue(progress);
                                repaint();
                            } else if (name.equals("state")) {
                                SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                                switch (state) {
                                    case DONE:
                                        start.setEnabled(true);
                                        break;
                                }
                            }
                        }

                    });
                    pw.execute();
                }
            });

        }
    }

    public class ProgressWorker extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {
            int i = 0;
            int max = 2000;

            while (i < max) {
                i += 10;
                int progress = Math.round(((float)i / (float)max) * 100f);
                setProgress(progress);
                try {
                    Thread.sleep(25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
}