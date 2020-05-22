public Javagame() {
    b1 = new JButton("Button!");
    b1.setActionCommand("change");

    b1.addActionListener(this);
    add(b1);

    // Move me here
    label = new JLabel("Hello World!", SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 20));
    label.setForeground(new Color(0x009900));
    add(label);
}