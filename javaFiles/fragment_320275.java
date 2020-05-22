JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    frame.setLayout(new GridLayout(2,1));
    panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
    panel.add(new JLabel("Reference  "));
    panel.add(new JButton("HI"));

    panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
    panel2.add(new JLabel("Reference2  "));
    panel2.add(new JButton("HI2"));

    frame.add(panel);
    frame.add(panel2);
    frame.setSize(500,300);
    frame.setVisible(true);