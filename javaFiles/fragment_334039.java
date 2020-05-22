for (int i = 0; i < 64; i++) {
    label[i] = new JButton();
    label[i].setBorderPainted(false);
    mainPanel.add(label[i]);
    label[i].setIcon(new ImageIcon(getClass()
        .getResource("/org/me/images/O.png")));
    label[i].setPreferredSize(new Dimension(50, 50));
    label[i].setToolTipText("label" + i);
}