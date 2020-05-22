public class PlayScene extends JFrame {

//declaration for time 
private static final String Play = "Play";
private static final String Pause = "Pause";
private Timer timer;
private long initTime = System.currentTimeMillis();
private long startTime;
private long pauseTime;
private boolean isRunning;

public void start() {
    if (!isRunning) {
        startTime = System.currentTimeMillis();
    } else {
        startTime = System.currentTimeMillis() - (pauseTime - startTime);
    }

    isRunning = true;
    timer.start();
}

public void pause() {
    pauseTime = System.currentTimeMillis();
    timer.stop();
}

private String getCurrentTime(long time) {
    return myFormat(time);
}

private String myFormat(final long time) {
    final long hr = TimeUnit.MILLISECONDS.toHours(time);
    final long min = TimeUnit.MILLISECONDS.toMinutes(time - TimeUnit.HOURS.toMillis(hr));
    final long sec = TimeUnit.MILLISECONDS.toSeconds(time - TimeUnit.HOURS.toMillis(hr)
            - TimeUnit.MINUTES.toMillis(min));
    final long ms = TimeUnit.MILLISECONDS.toMillis(time - TimeUnit.HOURS.toMillis(hr)
            - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec));
    return String.format("%02d:%02d:%02d.%01d", hr, min, sec, ms / 100);
}

public PlayScene() {
    super("Memory Game");
    setBounds(300, 40, 800, 600);

    final JButton buttonPlay = new JButton(Play);

    JLabel labelTimer = new JLabel("Timer");

    final JTextField text2 = new JTextField(15);
    text2.setEnabled(false);
    text2.setText(getCurrentTime(System.currentTimeMillis() - initTime));

    JLabel up = new JLabel();

    JLabel left = new JLabel();
    JLabel space1 = new JLabel("                           ");

    JLabel right = new JLabel();
    JLabel space2 = new JLabel("                            ");

    final JPanel upPanel = new JPanel(new FlowLayout());
    upPanel.add(labelTimer);
    upPanel.add(text2);

    JPanel bottomPanel = new JPanel(new FlowLayout());
    bottomPanel.add(buttonPlay);

    JPanel leftPanel = new JPanel(new FlowLayout());
    leftPanel.add(space1);

    JPanel rightPanel = new JPanel(new FlowLayout());
    rightPanel.add(space2);

    add(upPanel, BorderLayout.NORTH);
    add(bottomPanel, BorderLayout.SOUTH);
    add(leftPanel, BorderLayout.WEST);
    add(rightPanel, BorderLayout.EAST);

    setVisible(true);

    buttonPlay.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (Pause.equals(cmd)) {
                pause();
                buttonPlay.setText(Play);

            } else {
                buttonPlay.setText(Pause);
                start();
            }
        }
    });

    timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    text2.setText(getCurrentTime(System.currentTimeMillis() - initTime));
                }
            });
        }
    });
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new PlayScene();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    });
}

}