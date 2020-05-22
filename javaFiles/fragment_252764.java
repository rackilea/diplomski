JPanel panel = new JPanel(new GridLayout(10,10));
panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

for (int i =0; i<(10*10); i++){
    final JLabel label = new JLabel("Label");
    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.add(label);
}