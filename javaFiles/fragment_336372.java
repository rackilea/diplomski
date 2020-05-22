public void gui() {
    fra = new JFrame("ATR Utilities");
    fra.setSize(400, 600);
    fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pan = new JPanel(flow);
    pan.setBackground(Color.CYAN);

    but = new JButton("Test");
    lab = new JLabel("Test label");

    pan.add(but);
    pan.add(lab);
    fra.add(pan);
    fra.setVisible(true);
}