for (int ii = 0; ii < 20; ii++) {
    JButton jb1 = new JButton(new ImageIcon(img));
    JPanel panel = new JPanel(new BorderLayout());
    jb1.setMargin(new Insets(0, 0, 0, 0));
    jb1.setContentAreaFilled(false);
    jb1.setFocusPainted(false);
    jb1.setBorder(new EmptyBorder(0, 0, 0, 0));

    panel.add(jb1);
    add(panel);
}