public class UIThreadTest {

    private JFrame mainFrame;
    private JLabel labelStatus;
    private JButton buttonProcess;

    public static void main(String[] args) {
        final UIThreadTest ui = new UIThreadTest();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ui.initGUI();
            }
        });
    }

    public void initGUI() {
        mainFrame = new JFrame("View");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(200, 200);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        labelStatus = new JLabel("Status...");
        mainFrame.getContentPane().add(labelStatus, BorderLayout.NORTH);

        buttonProcess = new JButton("Start");
        buttonProcess.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable startLoop = new StartLoop();
                Thread startLoopThread = new Thread(startLoop);
                startLoopThread.start();
            }

        });
        mainFrame.getContentPane().add(buttonProcess, BorderLayout.SOUTH);
    }

    private void updateStatus(final int val) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                labelStatus.setText("Loading... (" + val + "%)");
            }
        });

    }

    private void runForLoop() {
        for (int i = 0; i < 18; i++) {
            int percent = (int) (((i + 1) * 100) / 18);
            updateStatus(percent);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class StartLoop implements Runnable {
        @Override
        public void run() {
            runForLoop();
        }

    }
}