public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("Hello");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2,1));

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(2, 2));

    JTextArea txtArea = new JTextArea("Place Holder");
    txtArea.setColumns(2);
    HelloActionListener listen = new HelloActionListener(txtArea);
    JButton b1 = new JButton("TOP");
    b1.addActionListener(listen);
    buttonsPanel.add(b1);
    JButton b2 = new JButton("LEFT");
    buttonsPanel.add(b2);
    JButton b3 = new JButton("RIGHT");
    buttonsPanel.add(b3);
    JButton b4 = new JButton("BOTTOM");
    b4.addActionListener(listen);
    buttonsPanel.add(b4);

    frame.add(txtArea);
    frame.add(buttonsPanel);

    frame.setVisible(true);
}