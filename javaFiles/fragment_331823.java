public ButtonClass() {
    JLabel background = new JLabel(new ImageIcon("image.png"));
    background.setLayout(new BorderLayout());
    setContentPane(background);
    setTitle("Background with buttons");
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    JPanel top = new JPanel();
    top.add(label);
    add(top, BorderLayout.NORTH);
    JPanel bottom = new JPanel();
    bottom.add(b1);
    bottom.add(b2);
    bottom.add(b3);
    bottom.add(b4);
    add(bottom, BorderLayout.SOUTH);
    //pack();
    setVisible(true);
}