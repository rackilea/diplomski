JFrame frame = new JFrame("Colored Trails");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel mainPanel = new JPanel();
mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

JPanel firstPanel = new JPanel();
firstPanel.setLayout(new GridLayout(4, 4));
firstPanel.setMaximumSize(new Dimension(400, 400));
JButton btn;
for (int i=1; i<=4; i++) {
    for (int j=1; j<=4; j++) {
        btn = new JButton();
        btn.setPreferredSize(new Dimension(100, 100));
        firstPanel.add(btn);
    }
}

JPanel secondPanel = new JPanel();
secondPanel.setLayout(new GridLayout(5, 13));
secondPanel.setMaximumSize(new Dimension(520, 200));
for (int i=1; i<=5; i++) {
    for (int j=1; j<=13; j++) {
        btn = new JButton();
        btn.setPreferredSize(new Dimension(40, 40));
        secondPanel.add(btn);
    }
}

mainPanel.add(firstPanel);
mainPanel.add(secondPanel);
frame.setContentPane(mainPanel);

frame.setSize(520,600);
frame.setMinimumSize(new Dimension(520,600));
frame.setVisible(true);