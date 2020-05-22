button.addActionListener(arg0 -> {
    JLabel newLabel = new JLabel("Label");
    labels.add(newLabel);
    panel.add(newLabel);
    panel.validate();
});