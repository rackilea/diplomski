JPanel panel = new JPanel();
EmptyBorder border = new EmptyBorder(5, 20, 5, 20);
LineBorder line = new LineBorder(Color.blue, 2, true);
CompoundBorder compound = new CompoundBorder(line, border);
for (int i = 0; i < 10; i++) {
    JLabel label = new JLabel("Label" + i);
    label.setBorder(compound);
    panel.add(label);
}