private void createComponents()
{
    JPanel panel=new createPanel();
    add(panel);
    button=new JButton("Push Me");
    label=new JLabel("This is a label");
    panel.add(button);
    panel.add(label);
}