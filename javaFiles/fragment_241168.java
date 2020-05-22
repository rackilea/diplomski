private JPanel getLabelPanel() {
    JPanel panel = new JPanel();
    panel.setOpaque(true);
    panel.setBackground(Color.BLUE);
    JLabel helloLabel = new JLabel("Hello World!", JLabel.CENTER);
    helloLabel.setForeground(Color.WHITE);
    panel.add(helloLabel);

    return panel;
}