private JPanel display1(){
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraint = new GridBagConstraints();
    panel.setLayout(new GridLayout(1,1));
    display1 = new JTextField("testing");
    constraint.gridx = 4;
    constraint.gridy = 0;
    panel.add(display1, constraint);
    return panel;
}

private JPanel display2(){
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraint = new GridBagConstraints();
    panel.setLayout(new GridLayout(1,1));
    display2 = new JTextField("testing");
    constraint.gridx = 4;
    constraint.gridy = 0;
    panel.add(display2, constraint);
    return panel;
}
private void bigDisplay(Container container){
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setLayout(new GridLayout(1,1));
    GridBagConstraints constraint = new GridBagConstraints();
    panel.add (display1 (), constraint);
    panel.add (display2 (), constraint);
    container.add(panel, "East");
}