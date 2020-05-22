public class Main {
private static Timer setVisibleTimer;
private static Timer setInvisibleTimer;

public static void main(String[] args) {

    final JLabel label = new JLabel("TEST ME ");
    JButton startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setVisibleTimer = new Timer(8000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setVisible(true);
                }
            });
            setInvisibleTimer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setVisible(false);
                }
            });
            setVisibleTimer.start();
            setInvisibleTimer.start();
        }
    });

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            label.setVisible(true);
            if (setVisibleTimer != null){
                setInvisibleTimer.stop();
                setVisibleTimer.stop();
            }
        }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(startButton);
    buttonPanel.add(cancelButton);

    JPanel cp = new JPanel();
    LayoutManager layout = new BoxLayout(cp, BoxLayout.Y_AXIS);
    cp.setLayout(layout);
    cp.add(buttonPanel);
    cp.add(label);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(cp);
    frame.pack();
    frame.setVisible(true);
}
}