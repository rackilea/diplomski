public class BlinkOut {

    public static void main(String[] args) {
        new BlinkOut();
    }

    public BlinkOut() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
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

        private JLabel[] labels;
        private int[] delays;
        private Timer timer;
        private int index;

        public TestPane() {
            setLayout(new GridLayout(0, 1));
            labels = new JLabel[7];
            for (int index = 0; index < 7; index++) {
                labels[index] = new JLabel("Label " + (index + 1));
                add(labels[index]);
            }
            delays = new int[] {2000, 3000, 2000, 2000, 2000, 2000, 2000};
            JButton hide = new JButton("Hide");
            add(hide);
            hide.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Click");
                    index = 0;
                    labels[index].setVisible(false);
                    timer.setDelay(delays[index]);
                    timer.start();
                }
            });
            timer = new Timer(delays[0], new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Tick");
                    timer.stop();
                    index++;
                    if (index < 7) {
                        labels[index].setVisible(false);
                        timer.setDelay(delays[index]);
                        timer.start();
                    }
                }
            });
            timer.setRepeats(false);
            timer.setCoalesce(true);
        }
    }

}