JPanel panel = new JPanel();
for (int i = 0; i < 10; i++) {
    JLabel label = new JLabel("Label" + i);
    EmptyBorder border = new EmptyBorder(5, 20, 5, 20);
    label.setBorder(border);
    panel.add(label);
}